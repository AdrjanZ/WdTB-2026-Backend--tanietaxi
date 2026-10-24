-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);

insert into user_account (email, display_name, role, created_at) values
    ('wrx81901@student.wroclaw.merito.pl', 'Adrian', 'USER', current_timestamp),
    ('s817346@student.wroclaw.merito.pl',  'Kamil',  'USER', current_timestamp),
    ('s489506@student.wroclaw.merito.pl',  'Maciek', 'USER', current_timestamp);

-- ===== LAB 02 · driver =====
insert into driver (full_name, phone, license_number, rating, active) values
    ('Tomasz Nowak',     '+48 601 234 567', 'WR-TX-0142', 4.85, true),
    ('Ewa Kowalczyk',    '+48 602 345 678', 'WR-TX-0217', 4.92, true),
    ('Paweł Wiśniewski', '+48 603 456 789', 'WR-TX-0388', 4.40, false),
    ('Marta Zielińska',  null,              'WR-TX-0451', null, true);

-- ===== LAB 02 · tariff =====
insert into tariff (name, vehicle_class, base_fare, price_per_km, valid_from) values
    ('Ekonomiczny dzienny', 'ECONOMY', 6.00,  2.40, '2026-10-01'),
    ('Ekonomiczny nocny',   'ECONOMY', 8.00,  3.00, '2026-10-01'),
    ('Komfort dzienny',     'COMFORT', 8.00,  3.20, '2026-10-01'),
    ('Van dla grupy',       'VAN',     12.00, 4.00, '2026-10-01');

-- ===== LAB 02 · ride =====
-- cena = opłata startowa + km × stawka z cennika (Ekonomiczny dzienny: 6.00 + km × 2.40, Komfort dzienny: 8.00 + km × 3.20)
insert into ride (pickup_address, destination_address, distance_km, price, status, ordered_at, rating) values
    ('pl. Grunwaldzki 1, Wrocław',  'ul. Fabryczna 29, Wrocław',         6.20,  20.88, 'COMPLETED', '2026-10-20 08:15:00', 5),
    ('ul. Piłsudskiego 105, Wrocław', 'ul. Graniczna 190, Wrocław (lotnisko)', 11.50, 44.80, 'COMPLETED', '2026-10-21 05:40:00', 4),
    ('ul. Ruska 46, Wrocław',       'ul. Legnicka 58, Wrocław',          3.10,  13.44, 'ACCEPTED',  '2026-10-24 12:05:00', null),
    ('Rynek 1, Wrocław',            'ul. Borowska 213, Wrocław',         4.80,  17.52, 'REQUESTED', '2026-10-24 12:30:00', null);

-- ===== LAB 02 · vehicle =====
-- Przykładowa flota; seats oznacza liczbę miejsc dla pasażerów, bez kierowcy.
insert into vehicle (brand, model, registration_number, seats, vehicle_class, active) values
    ('Toyota', 'Corolla',       'DW 1TX01', 4, 'ECONOMY', true),
    ('Skoda',  'Superb',        'DW 2TX02', 4, 'COMFORT', true),
    ('Ford',   'Tourneo Custom', 'DW 3TX03', 8, 'VAN',     true),
    ('Toyota', 'Yaris',         'DW 4TX04', 4, 'ECONOMY', false);
