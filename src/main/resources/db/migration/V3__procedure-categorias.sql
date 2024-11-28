DELIMITER $$
CREATE OR REPLACE PROCEDURE inserir_generos_livros()
BEGIN
    INSERT INTO categorias (nome)
    VALUES
        ('Romance'),
        ('Poesia'),
        ('Ficção Científica'),
        ('Fantasia'),
        ('Suspense'),
        ('Terror'),
        ('Biografia'),
        ('História'),
        ('Autoajuda'),
        ('Aventura'),
        ('Drama'),
        ('Comédia'),
        ('Infantil'),
        ('Jovem Adulto'),
        ('Distopia'),
        ('Clássicos'),
        ('Religião'),
        ('Ciência'),
        ('Tecnologia'),
        ('Educação'),
        ('Política'),
        ('Arte'),
        ('Filosofia');
END$$
DELIMITER ;

-- Chamando a procedure para inserir os gêneros
CALL inserir_generos_livros();
