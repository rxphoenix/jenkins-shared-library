package ca.qc.inspq.jenkins

@GrabResolver(name='mavenCentral', root='https://mvnrepository.com')
@Grab(group='org.yaml', module='snakeyaml', version='1.18')

import org.yaml.snakeyaml.Yaml

class AnsibleReader implements Serializable {
    def inventory

    def getInventory(String inventoryPath) {
        if (this.inventory == null) {
            this.inventory = new Inventory(inventoryPath)
        }
        return this.inventory;
    }

    class Inventory implements Serializable {
        def inventoryContent

        Inventory(def inventoryPath) {
            File file = new File(inventoryPath)
            FileInputStream stream = new FileInputStream(file)
            Yaml parser = new Yaml()
            inventoryContent = parser.load(stream)
        }

        def getValueFromKey(String name) {
            return inventoryContent.get(name)
        }
    }
}