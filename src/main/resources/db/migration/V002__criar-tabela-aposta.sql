CREATE TABLE aposta (
  id BIGINT NOT NULL AUTO_INCREMENT,
  solicitante_id BIGINT NOT NULL,
  numeros VARCHAR(20) NOT NULL,
  data_hora DATETIME NOT NULL,
  
  PRIMARY KEY (id)
 
);
  
ALTER TABLE aposta ADD CONSTRAINT fk_aposta_solicitante
FOREIGN KEY (solicitante_id) REFERENCES solicitante (id); 