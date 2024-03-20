import Data.List

-- Definição de tipos
type Evento = String
type Agenda = [Evento]

-- Função principal
main :: IO ()
main = do
    putStrLn "Bem-vindo ao Gerenciador de Agenda!"
    loop []

-- Função de loop para interação com o usuário
loop :: Agenda -> IO ()
loop agenda = do
    mostrarOpcoes
    opcao <- getLine
    case opcao of
        "1" -> adicionar agenda
        "2" -> remover agenda
        "3" -> mostrar agenda
        "4" -> putStrLn "Saindo do programa..."
        _   -> invalido agenda
            
--funções divididas

mostrarOpcoes :: IO()
mostrarOpcoes = do
    putStrLn "\nSelecione uma opção:"
    putStrLn "1. Adicionar evento"
    putStrLn "2. Remover evento"
    putStrLn "3. Visualizar agenda"
    putStrLn "4. Sair"

adicionar :: [Evento] -> IO()
adicionar agenda = do
    putStrLn "Digite o evento a ser adicionado:"
    evento <- getLine
    let novaAgenda = agenda ++ [evento]
    loop novaAgenda

remover :: [Evento] -> IO()
remover agenda = do
    putStrLn "Digite o índice do evento a ser removido:"
    indice <- getLine
    let novaAgenda = delete (agenda !! (read indice)) agenda                
    loop novaAgenda

mostrar :: [Evento] -> IO()
mostrar agenda = do
    putStrLn "Eventos na Agenda:"
    mapM_ putStrLn agenda
    loop agenda

invalido :: [Evento] -> IO()
invalido agenda = do
    putStrLn "Opção inválida. Tente novamente."
    loop agenda