# 💽🎛️ Sistema Gerenciador de Musicas

Este projeto permite que você crie e gerencie usuários, artistas, álbuns, músicas e playlists de maneira simples e intuitiva.

## Stack:
- Java 17
- JUnit
- Mockito
- Maven

## Funcionalidades:
- **Usuário e Artista**: criar usuários que podem criar playlists, e artistas que podem criar álbuns e ser creditados em músicas.
- **Música**: criar músicas e creditar artistas a elas.
- **Álbum e Playlist**: criar álbuns e playlists, onde também podemos adicionar músicas.

## Como Funciona:

### 1. Criar Usuário:
O usuário é criado com dois campos obrigatórios: *nome e username*.
```java
Usuario usuario = new Usuario("Natalia", "ntfrancisca");
```
  
### 2. Cadastrar Artista:
O artista é criado com três campos obrigatórios: *nome, username e descrição*.
```java
Artista artista = new Artista(
  "Duquesa",
  "duquesa",
  "Duquesa é uma rapper baiana que mistura rap, trap e R&B, destacando-se com os álbuns Taurus e Taurus, Vol. 2."
);
```

### 3. Cadastrar Album:
O álbum é criado com quatro campos obrigatórios: *id, título, data de lançamento e artista*.
```java
Album album = new Album(0, "Taurus, Vol.2", LocalDate.of(2024, 5, 10), artistas.buscarArtistaPorUsername("duquesa"));
```

### 4. Cadastrar Playlist:
A playlist é criada com três campos obrigatórios: *id, título e usuário responsável*.
```java
Playlist playlist = new Playlist(1, "girls want what???", usuarios.buscarUsuarioPorUsername("ntfrancisca"));
```

### 5. Cadastrar Música:
A música é criada com três campos obrigatórios: *id, título e duração*.
```
Musica musica = new Musica(3, "Disk P%#$#!", 2.30);
```
É importante atribuir artista(s) à música:
```
musica.atribuirArtista(artistas.buscarArtistaPorUsername("duquesa"));
musica.atribuirArtista(artistas.buscarArtistaPorUsername("tashaetracie"));
```

## O que aprendi com esse projeto:
- Aprendi mais sobre como estruturar e organizar um projeto em Java, definindo pacotes e responsabilidades claras para cada classe.
- Usei herança para lidar com diferentes classes que têm atributos e métodos em comum.
- Utilizei coleções como `LinkedHashMap`, `Set<Musica>` e `List<String>`, garantindo ordem de inserção, unicidade de elementos e flexibilidade na manipulação de dados.
- Apliquei conceitos de tratamento de exceções para lidar com erros e tornar o sistema mais robusto.
- Criei testes unitários para as classes de serviço, garantindo um código mais confiável e eficiente.


