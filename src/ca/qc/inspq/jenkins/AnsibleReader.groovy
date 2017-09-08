package ca.qc.inspq.jenkins

@GrabResolver(name='mavenCentral', root='https://mvnrepository.com')
@Grab(group='org.yaml', module='snakeyaml', version='1.18')

import org.yaml.snakeyaml.Yaml

class AnsibleReader implements Serializable {
    def inventaire

    def getInventaire(String inventaire) {
        if (this.inventaire == null) {
            this.inventaire = new Inventaire(inventaire)
        }
        return this.inventaire;
    }

    class Inventaire implements Serializable {
        def mapInventaire

        Inventaire(def inventaire) {
            File file = new File(inventaire)
            FileInputStream stream = new FileInputStream(file)
            Yaml parser = new Yaml()
            mapInventaire = parser.load(stream)
        }

        def getPropriete(String nom) {
            return mapInventaire.get(nom)
        }
    }
}