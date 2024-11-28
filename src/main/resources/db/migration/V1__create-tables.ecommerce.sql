CREATE TABLE usuarios (
  usuario_id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL
);

CREATE TABLE categorias (
  categoria_id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL
);

CREATE TABLE itens ( --  os livros
 item_id INT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(255) NOT NULL,
  preco DECIMAL(10, 2) NOT NULL,
  qtd_estoque INT NOT NULL,
  categoria_id INT,
  escritor VARCHAR(255) NOT NULL,
  FOREIGN KEY (categoria_id) REFERENCES categorias(categoria_id)
);

CREATE TABLE pedidos (
  pedido_id INT PRIMARY KEY AUTO_INCREMENT,
  usuario_id INT NOT NULL,
  dt_pedido DATE NOT NULL,
  total DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

CREATE TABLE itens_pedido ( -- Relaciona pedidos e itens (muitos para muitos)
  pedido_id INT NOT NULL,
  item_id INT NOT NULL,
  quantidade INT NOT NULL,
  preco DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (pedido_id, item_id),
  FOREIGN KEY (pedido_id) REFERENCES pedidos(pedido_id),
  FOREIGN KEY (item_id) REFERENCES itens(item_id)
);

CREATE TABLE pagamentos (
  pagamento_id INT PRIMARY KEY AUTO_INCREMENT,
  pedido_id INT NOT NULL,
  forma_pg VARCHAR(50) NOT NULL,
  FOREIGN KEY (pedido_id) REFERENCES pedidos(pedido_id)
);


CREATE TABLE auditoria_preco_item (
  auditoria_id INT PRIMARY KEY AUTO_INCREMENT,
  item_id INT NOT NULL,
  preco_antigo DECIMAL(10, 2) NOT NULL,
  preco_novo DECIMAL(10, 2) NOT NULL,
  dt_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (item_id) REFERENCES itens(item_id)
);
