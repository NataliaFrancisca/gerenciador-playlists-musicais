# 🖥️🎸  Sistema Gerenciador de Playlists Musicais

Este projeto permite que você crie e gerencie usuários, artistas, álbuns, músicas e playlists de maneira simples e intuitiva.

## Funcionalidades:
- **Gerenciamento de Usuários**: crie e gerencie usuários que podem ser donos de playlists.
  - `**Obs.:** não coloquei nenhuma regra para válidar usuários duplicados, mas podemos implementar depois.`
- **Gerenciamento de Artistas**: cadastre artistas e associe-os às suas músicas e álbuns.
  - `**Obs.:** não coloquei nenhuma regra para válidar artistas duplicados, mas podemos implementar depois.`
- **Gerenciamento de Álbuns**: crie álbuns e adicione músicas a eles.
- **Gerenciamento de Músicas**: cadastre músicas e vincule-as a artistas e álbuns.
- **Gerenciamento de Playlists**: crie playlists personalizadas adicionando músicas e atribua-as a usuários.

## Como Funciona:

### 1. Criar Usuários:
- Os usuários podem ser criados com um nome e um nome de usuário.
- **Exemplo:**
  ```java
  User user =
  UserService.create("Natalia", "natfrancisca");
  ```


### 2. Cadastrar Artista:
- Artistas podem ser cadastrados com um nome e uma breve descrição.
- **Exemplo:**
  ```java
  Artist duquesa = ArtistService.create(
    "Duquesa",
    "Duquesa é uma rapper baiana que mistura rap, trap e R&B, destacando-se com os álbuns Taurus e Taurus, Vol. 2."
  );

  Artist bk = ArtistService.create(
    "BK",
    "BK' é um dos principais rappers brasileiros, conhecido por suas letras impactantes sobre racismo, desigualdade e identidade."
  );
  ```

### 3. Adicionar Músicas:
- As músicas podem ser cadastradas com um título e duração.
- **Exemplo:**
  ```java
  Song songA = SongService.create("Fuso", 1.54);
  Song songB = SongService.create("Só Quero Ver", 2.49);
  ```

### 4. Criar Álbuns: 
- Para criar um álbum é preciso passar o título, artista e a data de lançamento.
- É possível adicionar músicas a esse álbum que foi criado.
- **Exemplo:**
  ```java
  Album album = AlbumService.create(
    "Diamantes, Lágrimas, e Rostos para Esquecer",
    bk,
    LocalDate.of(2025, 1, 28)
  );

  AlbumService.addSong(album, songB);
  ```

### 5. Criar Playlists:
- Playlists podem ser criadas por usuários e preenchidas com músicas.
- **Exemplo:**
  ```java
  Playlist playlist = PlaylistService.create("Minhas Favoritas", user);
  playlist.addSong(songA);
  playlist.addSong(songB);
  ```

## O que aprendi com esse projeto:
- Aprendi mais sobre como estruturar e organizar um projeto em Java, definindo pacotes e responsabilidades claras para cada classe.
- Utilizei a `LinkedHashSet` para garantir que apenas músicas únicas fossem adicionadas, mantendo a ordem de inserção na coleção.
- Apliquei conceitos de tratamento de exceções para lidar com erros e garantir que o sistema seja mais robusto.
- Utilizei o conceito de Composição para evitar duplicação de código. Em vez de `Playlist` e `Album` terem métodos repetidos (`addSong` e `removeSong`), criei a classe Songs para centralizar esses comportamentos e reutilizá-los em ambas as classes.

  
