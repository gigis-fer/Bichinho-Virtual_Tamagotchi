
/*
Fome (quanto maior, mais fome)
Felicidade (quanto maior, mais feliz)
Alimentar: diminui a fome
Brincar: aumenta a felicidade
Verificar status: mostra os valores atuais do pet

Fome: aumenta em 3
Felicidade: diminui em 3
Cansaço: aumenta em 10
Idade: aumenta em 1
 */

class Pet (val name: String) {
    var nivelFome: Int = 50
    var nivelFelicidade: Int = 50
    var nivelCansaco: Int = 0
    var age: Int = 0

    fun verificarStatus() {
        println("Status atual de $name: ")
        println("Idade: $age")
        println("Nível alegria: $nivelFelicidade")
        println("Nível de fome: $nivelFome")
        println("Nível de Cansaço: $nivelCansaco")
    }

    fun alimentar(){
        nivelFome = (nivelFome - 10)
        println("$name comeu uma refeição deliciosa! A fome diminuiu.")
    }

    fun brincar(){
        nivelFelicidade =(nivelFelicidade + 10)
        nivelCansaco = (nivelCansaco + 10)
        println("$name adorou brincar! A felicidade aumentou, mas o cansaço também.")

    }

    fun descansar(){
        if (nivelCansaco >= 10){
            nivelCansaco -= 10
        } else {
            nivelCansaco = 0
        }
        println("$name tirou uma soneca refrescante! O cansaço diminuiu.")
    }

    fun passarTempo(){
        nivelFome = (nivelFome + 3 )
        nivelFelicidade =(nivelFelicidade - 3)
        nivelCansaco = (nivelCansaco +10)
        age = (age+1)
    }

    fun verificarDerrota(): Boolean {
        if (nivelFome >= 100) {
            println("\n$name morreu de fome! Fim de jogo.")
            return true
        }
        if (nivelCansaco >= 100) {
            println("\n$name exausto desmaiou de cansaço! Fim de jogo.")
            return true
        }
        if (nivelFelicidade <= 0) {
            println("\n$name ficou triste demais e fugiu! Fim de jogo.")
            return true
        }
        return false
    }

    fun verificarVitoria(): Boolean {
        if (age >= 50) {
            println("\nParabéns! $name chegou aos 50 anos saudável e feliz! Você venceu!")
            return true
        }
        return false
    }


}

fun main() {
    println("Bem-vindo(a) ao Simulador de Animal de Estimação Virtual!")
    print("Digite o nome do seu novo Pet: ")
    val namePet = readln().ifBlank { "Gabriel bezerra" }

    val meuPet = Pet(namePet)
    println("${meuPet.name} nasceu! Cuide bem dele até atingir a idade de 50 anos")

    while (true) {

        println("---Escolha uma ação---")
        println("1. Alimentar ${meuPet.name}")
        println("2. Brincar com ${meuPet.name}")
        println("3. Verificar o status de ${meuPet.name}")
        println("4. Descansar ${meuPet.name}")
        println("5. Deixar o tempo passar")
        println("6. Sair")
        print("Sua escolha: ")

       var escolha = readln ().toIntOrNull() ?: continue

        when (escolha) {
            1 -> meuPet.alimentar()
            2 -> meuPet.brincar()
            3 -> meuPet.verificarStatus()
            4 -> meuPet.descansar()
            5 -> println("${meuPet.name} passou o tempo olhando pro nada...")
            6 -> {
                println("Saindo do simulador. Até logo!")
                break
            }

            else -> {
                println("Opção inválida! Tente novamente.")
                continue
            }
        }
        meuPet.passarTempo()

        if (meuPet.verificarDerrota() || meuPet.verificarVitoria()) {
            break
        }
    }
}