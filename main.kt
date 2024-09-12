interface State {
    fun open(door:Door)
    fun close(door: Door)
}

class CloseState: State{
    override fun open(door:Door){
        println("열었습니다");
        door.setState(OpenState())
    }
    
    override fun close(door:Door){
        println("이미 닫혀있습니다.")
    }
    
}

class OpenState: State{
    override fun open(door:Door){
        println("이미 열려있습니다.");
    }
    override fun close(door:Door){
        println("문을 닫았습니다.");
        door.setState(CloseState())
    }
}

class Door{
    private var state: State = CloseState()
    
    fun setState(state:State){
        this.state = state
    }
    
    fun open(){
        state.open(this)
    }
    
    fun close(){
        state.close(this)
    }
}

fun main() {
    var door = Door()
    door.open()
    door.open()
    door.close()
    door.close()
}