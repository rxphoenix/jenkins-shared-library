package ca.qc.inspq.jenkins

class AnsibleReader implements Serializable {
    WorkflowScript script
    AnsibleReader(WorkflowScript script) {
        this.script = script;
    }
    
    def test() {
        //sh('echo "allo"')
        //echo "allo"
        this.script.echo("allo")
    }
}