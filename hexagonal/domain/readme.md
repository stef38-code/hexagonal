# Partie Metier/Domain/Business du projet
Celui-ci ne doit pas voir de dépendance avec des FrameWork, il doit être le plus pure possible.
Le but de ce module est d'avoir un impact mineur en cas de changement de version de Java

![](./doc/dangergeneralpetit.png)
* @Controller, @Service,@Repository,@Compoment
* Mapper
* cette partie ne doit pas importer un seul élément du `in` ou du `out`
* etc...

L'avantage de cette solution
* de pouvoir développer la partie métier sans avoir les entrées/sorties déjà de définie
* création de TU plus facilement
* impact réduit
    * si un des éléments d'entrée/sortie change
    * si mise à jour de lib, framework


Dans notre cas, l’hexagone avait trois exceptions :
* Apache Commons Lang3 (StringUtils)
* SLF4J
* JSR305 de Findbugs

# Structure
La structure de ce module est la suivante :
* entities : les entités qui seront utilisées uniquement dans ce module
* business les traitements autrement dit __les UseCase__
* port : interfaces de communication avec les entrées/sorties
    * in : les entrées, par exemple : un client web ou un batch
    * out : les interactions avec services ( repository, fichier, service http/soap, etc..)


# Définition
## Une classe Business
Il est conseillé d'avoir une classe pour une action mais chacun fait comme il veut.
La méthode(exposée) sera souvent composée des paramètres suivants :
* une entité qui est dans son module `Personne`
* une interface de sortie `out` vers une service extérieur `Enregistrer`
* une interface d'entrée `in` vers le service d'entrée afin de lui donner la réponse `AjouterReponse`

Et retournera un __void__, sisi puisque le retour sera fait pas l'interface d'entrée `in`

Exemple :
```java
package org.stephane.domain.business;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.AjouterReponse;
import org.stephane.domain.port.out.Enregistrer;

public class UseCasePersonne {

  public void ajouter(Personne personne, Enregistrer enregistrer, AjouterReponse reponse) {
    Personne resultat = enregistrer.execute(personne);
    reponse.donner(resultat);
  }
  //...etc
}
```

## Une Sortie
La définition d'une sortie doit se composer d'une interface pour une action.
exemple vers un repository
```java
package org.stephane.domain.port.out.personne;

import org.stephane.domain.entities.Personne;

public interface Enregistrer {
  Personne execute(Personne personne);
}
```
## Une Entrée
La définition d'une entrée doit se composer d'une interface pour une action.
exemple :
```java
package org.stephane.domain.port.in.personne;

import org.stephane.domain.entities.Personne;

public interface AjouterReponse {
  void donner(Personne resultat); //resultat donné par la UseCase
  Personne recuperer();// récupération par @service par exemple du résultat
}
```

# Faire un Test unitaire
Les tests unitaires seront plus simple à réaliser grâce aux interfaces __d'entrée__ et __sortie__
```java
package org.stephane.domain.business;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.AjouterReponse;
import org.stephane.domain.port.out.Enregistrer;

import java.time.LocalDate;
import java.util.UUID;

class UseCasePersonneTest {
    MockEnregistrerPersonne mockSavePersonne = new MockEnregistrerPersonne();
    MockAjouterReponse mockAddReponse = new MockAjouterReponse();

    @Test
    void ajouter() {
        UseCasePersonne business = new UseCasePersonne();
        Personne personne = Personne.Builder.newInstance()
                .nom("Solomon")
                .prenom( "Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build();
        business.ajouter(personne,mockSavePersonne,mockAddReponse);
        Personne resultat = mockAddReponse.recuperer();
        Assertions.assertThat(resultat).isNotNull();
        Assertions.assertThat(resultat.getId()).isNotBlank();
    }


    private class MockEnregistrerPersonne implements Enregistrer {

        @Override
        public Personne execute(Personne personne) {
            return Personne.Builder.newInstance().clone(personne).id(UUID.randomUUID().toString()).build();
        }
    }
    private class MockAjouterReponse implements AjouterReponse {
        private Personne resultat;
        @Override
        public void donner(Personne resultat) {
            this.resultat = resultat;
        }

        @Override
        public Personne recuperer() {
            return resultat;
        }
    }
}
```
