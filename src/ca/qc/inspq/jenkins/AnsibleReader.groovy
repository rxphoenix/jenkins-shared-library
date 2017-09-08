package ca.qc.inspq.jenkins

@GrabResolver(name='mavenCentral', root='https://mvnrepository.com')
@Grab(group='org.yaml', module='snakeyaml', version='1.18')

import org.yaml.snakeyaml.Yaml

class AnsibleReader implements Serializable {
    def inventoryContent

    AnsibleReader(String inventoryPath) {
        File file = new File(inventoryPath)
        FileInputStream stream = new FileInputStream(file)
        Yaml parser = new Yaml()
        this.inventoryContent = parser.load(stream)
    }

    def getValueFromKey(String name) {
        return inventoryContent.get(name)
    }
}