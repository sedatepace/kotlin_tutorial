interface State {
    fun play(player: Player)
    fun pause(player:Player)
}

class PlayState:State{
    override fun play(player:Player){
        println("이미 플레이중입니다.")
    }
    
    override fun pause(player:Player){
        println("중지하였습니다.")
        player.setState(PauseState())
    }
}

class PauseState:State{
    override fun play(player:Player){
        println("플레이 합니다.")
        player.setState(PlayState())
    }
    override fun pause(player:Player){
        println("이미 중지중입니다.")
    }
}

class Player{
    private var state: State = PauseState();
    
    fun setState(state:State){
        this.state = state
    }
    
    fun play(){
        state.play(this)
    }
    
    fun pause(){
        state.pause(this)
    }
    
}

fun main() {
  var player = Player();
    player.play()
    player.play()
    player.pause()
    player.pause()
    
}