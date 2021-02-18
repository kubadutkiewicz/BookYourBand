INSERT INTO client (id, email, is_enabled, password, role, user_name)
values
(1, 'kuba@kuba.com', true, 'Kuba', null, 'Kuba'),
(2, 'asia@asia.com', true, 'Asia', null, 'Asia'),
(3, 'igor@igor.com', true, 'Igor', null, 'Igor');

insert into band (id, band_name, location, rating)
values
(1, 'Jama', 'Ruda Slaska', 5.0),
(2, 'Wpuszczeni w maliny', 'Chorzow', 4.9),
(3, 'Poparzeni herbata', 'Gliwice', 4.5);

insert into band_Booking (date, band_id, client_id)
values
('14/02/2021', 1, 1),
('05/06/2021', 1, 3);

insert into comments (BAND_ID, COMMENT_CONTENT, LOGIN, RATING)
values
(1, 'Najlepszy zespół na świecie', 'Rafał', 5),
(1, 'Bardzo fajnie grają', 'Igor', 5);