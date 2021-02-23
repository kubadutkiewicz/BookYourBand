INSERT INTO client (id, email, is_enabled, password, role, user_name)
values
(1, 'kuba@kuba.com', true, '$2a$10$kZ3gF6h6WwQGYjuw373v5eCuOaWs.3GuKc5AkCqsHgZLsbR17GYGa', 'ROLE_USER', 'Kuba'),
(2, 'asia@asia.com', true, 'Asia', 'ROLE_USER', 'Asia'),
(3, 'igor@igor.com', true, 'Igor', 'ROLE_USER', 'Igor');

insert into band (id, band_name, location, rating)
values
(1, 'Jama', 'Ruda Slaska', 5.0),
(2, 'Wpuszczeni w maliny', 'Chorzow', 4.9),
(3, 'Poparzeni herbata', 'Gliwice', 4.5);

insert into band_Booking (date, band_id, client_id)
values
('2021-02-14', 1, 1),
('2021-06-05', 1, 3);

insert into comments (band_Id, client_Id, comment_Text, rating)
values
(1, 1, 'Najlepszy zespół na świecie', 5),
(1, 2, 'Bardzo fajnie grają', 5);