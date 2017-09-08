package ca.qc.inspq.jenkins

@GrabResolver(name='mavenCentral', root='https://mvnrepository.com')
@Grab(group='org.yaml', module='snakeyaml', version='1.18')

import org.yaml.snakeyaml.Yaml

class AnsibleReader implements Serializable {
    def script
    AnsibleReader(def script) {
        this.script = script;
    }

    def test() {
        //sh('echo "allo"')
        //echo "allo"
        Yaml parser = new Yaml()
        this.script.echo("allo")
    }
}