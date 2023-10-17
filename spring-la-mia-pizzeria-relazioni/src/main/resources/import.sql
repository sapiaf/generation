INSERT INTO pizze (nome, descrizione, prezzo, foto_url) VALUES('Margherita', 'Pizza classica con pomodoro, mozzarella e basilico.', 8.99, 'https://pizzium.com/wp-content/uploads/2022/02/MARGHERITA-1.jpg')
INSERT INTO pizze (nome, descrizione, prezzo, foto_url) VALUES ('Marinara', 'Pomodori pelati, datterini rossi freschi, filetti di alici, olive denocciolate, capperi, origano e aglio', 9.99, 'https://pizzium.com/wp-content/uploads/2022/06/MARINARA-SECONDO-PIZZIUM.jpg');
INSERT INTO pizze (nome, descrizione, prezzo, foto_url)  VALUES ('Bufalina', 'Pomodori pelati, spolverata di Grana Padano DOP e mozzarella di bufala campana DOP', 10.99, 'https://pizzium.com/wp-content/uploads/2022/02/Bufalina-2.jpg');
INSERT INTO pizze (nome, descrizione, prezzo, foto_url)  VALUES ('Napoli', 'Pomodori pelati, fior di latte d’Agerola e filetti di alici', 10.99, 'https://pizzium.com/wp-content/uploads/2022/02/Napoli-2.jpg');
INSERT INTO pizze (nome, descrizione, prezzo, foto_url)  VALUES ('Carbonara', 'Fior di latte d’Agerola, guanciale, pecorino romano DOP, tuorlo d’uovo e pepe nero', 9.99, 'https://pizzium.com/wp-content/uploads/2022/02/LAZIO-1.jpg');
INSERT INTO offerte (titolo, data_inizio, data_fine, pizza_id) VALUES ('Offerta Estiva', '2023-06-01', '2023-08-31', 1);
INSERT INTO offerte (titolo, data_inizio, data_fine, pizza_id) VALUES ('Sconto Autunnale', '2023-09-01', '2023-11-30', 2);
INSERT INTO offerte (titolo, data_inizio, data_fine, pizza_id) VALUES ('Promozione Invernale', '2023-12-01', '2024-02-28', 3);
INSERT INTO ingredienti (nome) VALUES ('Pomodoro');
INSERT INTO ingredienti (nome) VALUES ('Mozzarella');
INSERT INTO ingredienti (nome) VALUES ('Basilico');
INSERT INTO ingredienti (nome) VALUES ('Alici');
INSERT INTO ingredienti (nome) VALUES ('Olive');
INSERT INTO ingredienti (nome) VALUES ('Capperi');
INSERT INTO ingredienti (nome) VALUES ('Origano');
INSERT INTO ingredienti (nome) VALUES ('Aglio');
INSERT INTO ingredienti (nome) VALUES ('Grana Padano DOP');
INSERT INTO ingredienti (nome) VALUES ('Mozzarella di Bufala DOP');
INSERT INTO ingredienti (nome) VALUES ('Fior di Latte');
INSERT INTO ingredienti (nome) VALUES ('Guanciale');
INSERT INTO ingredienti (nome) VALUES ('Pecorino Romano DOP');
INSERT INTO ingredienti (nome) VALUES ('Tuorlo d’Uovo');
INSERT INTO ingredienti (nome) VALUES ('Pepe Nero');