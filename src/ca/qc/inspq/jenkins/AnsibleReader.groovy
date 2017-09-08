package ca.qc.inspq.jenkins

class AnsibleReader implements Serializable {
    def script
    AnsibleReader(def script) {
        this.script = script;
    }

    def test() {
        //sh('echo "allo"')
        //echo "allo"
        this.script.echo("allo")
    }
}