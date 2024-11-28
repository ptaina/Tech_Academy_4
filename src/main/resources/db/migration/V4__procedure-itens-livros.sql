DELIMITER $$

CREATE OR REPLACE PROCEDURE inserir_livros_diversos()
BEGIN

    INSERT INTO itens (titulo, preco, qtd_estoque, categoria_id, escritor)
    VALUES
     -- Literatura
    ('Orgulho e Preconceito', 39.99, 100, 1, 'Jane Austen'),
    ('O Morro dos Ventos Uivantes', 49.99, 50, 1, 'Emily Brontë'),
    ('Romeu e Julieta', 29.99, 75, 1, 'William Shakespeare'),
    ('E o Vento Levou', 69.99, 30, 1, 'Margaret Mitchell'),
    ('O Grande Gatsby', 39.99, 80, 1, 'F. Scott Fitzgerald'),
    ('Cinquenta Tons de Cinza', 59.99, 60, 1, 'E.L. James'),
    ('O Sol Também é uma Estrela', 24.99, 150, 1, 'Nicola Yoon'),
    ('Sentimento e Sensibilidade', 45.99, 90, 1, 'Jane Austen'),
    ('O Diário de uma Paixão', 34.99, 120, 1, 'Nicholas Sparks'),

    -- Poesia
    ('O Corvo', 19.99, 120, 2, 'Edgar Allan Poe'),
    ('O Cântico de Sol', 22.99, 80, 2, 'Fernando Pessoa'),
    ('Cadernos de Poesia', 25.99, 100, 2, 'Carlos Drummond de Andrade'),
    ('Sonetos', 29.99, 70, 2, 'William Shakespeare'),
    ('Antologia Poética', 34.99, 150, 2, 'Vinícius de Moraes'),

    -- Ficção Científica
    ('1984', 29.99, 100, 3, 'George Orwell'),
    ('Fahrenheit 451', 24.99, 120, 3, 'Ray Bradbury'),
    ('A Guerra dos Mundos', 39.99, 80, 3, 'H.G. Wells'),
    ('Duna', 49.99, 60, 3, 'Frank Herbert'),
    ('Neuromancer', 34.99, 90, 3, 'William Gibson'),
    ('O Homem do Castelo Alto', 39.99, 50, 3, 'Philip K. Dick'),
    ('A Máquina do Tempo', 19.99, 110, 3, 'H.G. Wells'),
    ('O Guia do Mochileiro das Galáxias', 29.99, 140, 3, 'Douglas Adams'),
    ('A Mão Esquerda da Escuridão', 34.99, 80, 3, 'Ursula K. Le Guin'),
    ('A Ilha do Dr. Moreau', 22.99, 100, 3, 'H.G. Wells'),

    -- Fantasia
    ('O Senhor dos Anéis', 49.99, 100, 4, 'J.R.R. Tolkien'),
    ('Harry Potter e a Pedra Filosofal', 39.99, 120, 4, 'J.K. Rowling'),
    ('A Crônica do Matador do Rei', 44.99, 80, 4, 'Patrick Rothfuss'),
    ('O Nome do Vento', 34.99, 90, 4, 'Patrick Rothfuss'),
    ('O Ciclo da Herança', 29.99, 110, 4, 'Christopher Paolini'),

    -- Suspense
    ('O Silêncio dos Inocentes', 39.99, 70, 5, 'Thomas Harris'),
    ('Garota Exemplar', 34.99, 90, 5, 'Gillian Flynn'),
    ('O Colecionador de Ossos', 29.99, 110, 5, 'Jeffery Deaver'),
    ('O Homem de Giz', 44.99, 60, 5, 'C.J. Tudor'),
    ('A Paciente Silenciosa', 49.99, 80, 5, 'Alex Michaelides'),

    -- Terror
    ('It - A Coisa', 59.99, 60, 6, 'Stephen King'),
    ('O Iluminado', 49.99, 80, 6, 'Stephen King'),
    ('A Casa Infernal', 39.99, 100, 6, 'Richard Matheson'),
    ('O Exorcista', 29.99, 120, 6, 'William Peter Blatty'),
    ('Drácula', 34.99, 90, 6, 'Bram Stoker'),

    -- Biografia
    ('Steve Jobs', 39.99, 100, 7, 'Walter Isaacson'),
    ('O Diário de Anne Frank', 29.99, 110, 7, 'Anne Frank'),
    ('Quando a Noite Cai', 44.99, 80, 7, 'Edney Silvestre'),
    ('Eu Sou Malala', 34.99, 90, 7, 'Malala Yousafzai'),
    ('A História de Minha Vida', 49.99, 70, 7, 'Helen Keller'),

    -- História
    ('Sapiens: Uma Breve História da Humanidade', 49.99, 100, 8, 'Yuval Noah Harari'),
    ('Guns, Germs, and Steel', 44.99, 80, 8, 'Jared Diamond'),
    ('O Príncipe', 39.99, 90, 8, 'Nicolau Maquiavel'),
    ('A História do Mundo para Quem Tem Pressa', 29.99, 120, 8, 'Ken Follett'),
    ('A Segunda Guerra Mundial', 59.99, 60, 8, 'Winston Churchill'),

    -- Autoajuda
    ('O Poder do Hábito', 29.99, 100, 9, 'Charles Duhigg'),
    ('Pense Simples', 19.99, 120, 9, 'Gustavo Cerbasi'),
    ('Os 7 Hábitos das Pessoas Altamente Eficazes', 39.99, 80, 9, 'Stephen Covey'),
    ('A Mágica da Arrumação', 34.99, 90, 9, 'Marie Kondo'),
    ('Você Pode Curar Sua Vida', 24.99, 110, 9, 'Louise Hay'),

    -- Aventura
    ('As Aventuras de Huckleberry Finn', 29.99, 100, 10, 'Mark Twain'),
    ('A Ilha do Tesouro', 39.99, 80, 10, 'Robert Louis Stevenson'),
    ('Vingadores: A Ascensão do Imbatível', 44.99, 60, 10, 'Stan Lee'),
    ('O Senhor das Moscas', 34.99, 90, 10, 'William Golding'),
    ('O Conde de Monte Cristo', 49.99, 70, 10, 'Alexandre Dumas'),

    -- Drama
    ('Hamlet', 19.99, 120, 11, 'William Shakespeare'),
    ('Macbeth', 24.99, 100, 11, 'William Shakespeare'),
    ('A Morte de Ivan Ilitch', 29.99, 90, 11, 'Lev Tolstói'),
    ('Crime e Castigo', 39.99, 80, 11, 'Fiódor Dostoiévski'),
    ('A Casa de Bernarda Alba', 34.99, 70, 11, 'Federico García Lorca'),

    -- Comédia
    ('O Mercado de Pulgas', 19.99, 110, 12, 'Luis Fernando Veríssimo'),
    ('A Vida Como Ela É', 24.99, 100, 12, 'Nelson Rodrigues'),
    ('A Comédia dos Erros', 29.99, 70, 12, 'William Shakespeare'),
    ('O Auto da Compadecida', 39.99, 80, 12, 'Ariano Suassuna'),
    ('O Casamento', 34.99, 100, 12, 'Mário de Andrade'),

    -- Infantil
    ('O Pequeno Príncipe', 19.99, 150, 13, 'Antoine de Saint-Exupéry'),
    ('Onde Vivem os Monstros', 24.99, 110, 13, 'Maurice Sendak'),
    ('A Turma da Mônica', 29.99, 120, 13, 'Maurício de Sousa'),
    ('O Menino Maluquinho', 34.99, 90, 13, 'Ziraldo'),
    ('O Mágico de Oz', 39.99, 80, 13, 'L. Frank Baum'),

    -- Jovem Adulto
    ('Cidades de Papel', 24.99, 110, 14, 'John Green'),
    ('O Lado Bom da Vida', 29.99, 100, 14, 'Matthew Quick'),
    ('O Ladrão de Raios', 34.99, 90, 14, 'Rick Riordan'),
    ('Os 13 Porquês', 39.99, 80, 14, 'Jay Asher'),
    ('A Culpa é das Estrelas', 29.99, 120, 14, 'John Green'),

    -- Distopia
    ('Jogos Vorazes', 39.99, 100, 15, 'Suzanne Collins'),
    ('Divergente', 29.99, 90, 15, 'Veronica Roth'),
    ('A Hospedeira', 34.99, 80, 15, 'Stephenie Meyer'),
    ('O Conto da Aia', 44.99, 60, 15, 'Margaret Atwood'),
    ('O Hospício', 29.99, 110, 15, 'Stephen King'),

    -- Clássicos
    ('A Moreninha', 29.99, 100, 16, 'Joaquim Manuel de Macedo'),
    ('Senhora', 39.99, 80, 16, 'José de Alencar'),
    ('Dom Casmurro', 49.99, 60, 16, 'Machado de Assis'),
    ('Iracema', 34.99, 120, 16, 'José de Alencar'),
    ('O Primo Basílio', 44.99, 100, 16, 'José de Alencar'),

    -- Religião
    ('A Bíblia Sagrada', 49.99, 100, 17, 'Diversos'),
    ('O Alcorão', 39.99, 80, 17, 'Diversos'),
    ('O Livro de Mórmon', 34.99, 90, 17, 'Diversos'),
    ('A Cabana', 29.99, 120, 17, 'William P. Young'),
    ('O Tao Te Ching', 24.99, 100, 17, 'Lao Tsé'),

    -- Ciência
    ('O Andar do Bêbado', 29.99, 100, 18, 'Leonard Mlodinow'),
    ('A Origem das Espécies', 49.99, 60, 18, 'Charles Darwin'),
    ('O Universo Numa Casca de Noz', 39.99, 90, 18, 'Stephen Hawking'),
    ('O Gene', 44.99, 80, 18, 'Siddhartha Mukherjee'),
    ('O Andarilho das Estrelas', 34.99, 70, 18, 'Carl Sagan'),

    -- Tecnologia
    ('O Dilema da Inovação', 29.99, 100, 19, 'Clayton Christensen'),
    ('A Quarta Revolução Industrial', 34.99, 80, 19, 'Klaus Schwab'),
    ('O Código da Vinci', 44.99, 60, 19, 'Dan Brown'),
    ('A Era da Automação', 39.99, 110, 19, 'Erik Brynjolfsson'),
    ('O Futuro da Vida', 49.99, 70, 19, 'Edward O. Wilson'),

    -- Educação
    ('Pedagogia do Oprimido', 29.99, 100, 20, 'Paulo Freire'),
    ('A Educação Infantil', 24.99, 120, 20, 'Célia Lessa'),
    ('Ensinar e Aprender', 39.99, 90, 20, 'Maria de Lourdes Pinto de Almeida'),
    ('Psicologia da Educação', 44.99, 80, 20, 'Leandro Konder'),
    ('Teoria da Educação', 34.99, 100, 20, 'Gilbert Ryle'),

    -- Política
    ('O Príncipe', 29.99, 100, 21, 'Nicolau Maquiavel'),
    ('A Política', 39.99, 80, 21, 'Aristóteles'),
    ('O Capital', 44.99, 70, 21, 'Karl Marx'),
    ('A Sociedade Aberta e Seus Inimigos', 49.99, 60, 21, 'Karl Popper'),
    ('Os Ensaios', 34.99, 90, 21, 'Michel de Montaigne'),

    -- Arte
    ('A História da Arte', 59.99, 50, 22, 'E.H. Gombrich'),
    ('O Olhar do Artista', 39.99, 100, 22, 'John Berger'),
    ('O Quarto de Van Gogh', 44.99, 70, 22, 'Éric Roussel'),
    ('A Arte de Ver', 29.99, 90, 22, 'Rudolf Arnheim'),
    ('Arte Contemporânea', 39.99, 80, 22, 'Nicholas Serota'),

    -- Filosofia
    ('A República', 39.99, 100, 23, 'Platão'),
    ('Crítica da Razão Pura', 49.99, 90, 23, 'Immanuel Kant'),
    ('O Ser e o Nada', 59.99, 60, 23, 'Jean-Paul Sartre'),
    ('O Anticristo', 34.99, 110, 23, 'Friedrich Nietzsche'),
    ('A Fenomenologia do Espírito', 29.99, 80, 23, 'Georg Wilhelm Friedrich Hegel');

END $$

DELIMITER ;

CALL inserir_livros_diversos();
