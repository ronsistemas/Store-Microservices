DROP TABLE IF EXISTS tlb_invoices ;

CREATE TABLE tlb_invoices (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  number_invoice VARCHAR(50) NOT NULL,
  description VARCHAR(250) NOT NULL,
  customer_id BIGINT NOT NULL,
  create_at DATE NOT NULL,
  state  VARCHAR(20)
);

DROP TABLE IF EXISTS tbl_invoce_items ;

CREATE TABLE tbl_invoce_items (
  id_item BIGINT AUTO_INCREMENT PRIMARY KEY,
  invoice_id BIGINT  NOT NULL,
  product_id BIGINT NOT NULL,
  quantity DOUBLE NOT NULL,
  price DOUBLE NOT NULL
);
