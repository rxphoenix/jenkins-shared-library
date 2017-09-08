package ca.qc.inspq.jenkins

@GrabResolver(name='mavenCentral', root='https://mvnrepository.com')
@Grab(group='org.yaml', module='snakeyaml', version='1.18')

import org.yaml.snakeyaml.Yaml

class AnsibleReader implements Serializable {
    def script
    AnsibleReader(def script) {
        this.script = script;
    }

    def test(String inventaire) {
        File file = new File(inventaire)
        FileInputStream stream = new FileInputStream(file)
        Yaml parser = new Yaml()
        def map = parser.load(stream)
        this.script.echo(map.get('faius_container_name'))

        this.script.echo("allo")
    }
}