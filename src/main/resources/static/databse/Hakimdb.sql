drop database if exists hakimlivsdb;
create database hakimlivsdb;
use hakimlivsdb;


CREATE table if not exists Kategori (
id int not null auto_increment,
namn varchar(50) not null,
moms int not null,

primary key (id)
);

insert into Kategori (namn, moms) values 
('Skafferi', 11),
('Godis', 11),
('Hygienartiklar', 25),
('Städ', 25),
('Tidsskrifter', 6);


CREATE table if not exists Kunder (
id int not null auto_increment,
email varchar(50) not null,
förNamn varchar(50) not null,
efterNamn varchar(50) not null,
adress varchar(50) not null,
postNummer int not null,
ort varchar(30) not null,
kundPassword varchar(30),
vip boolean not null,
aktiv boolean not null,
skapad varchar(30) not null,
editerad varchar(30) not null,

primary key (id)
);

insert into Kunder (id, email, förNamn, efterNamn, adress, postNummer, ort, kundPassword, vip, aktiv, skapad, editerad) values
(1, 'eva@eva.com', 'Eva', 'Evasson', 'Gatugatan 1A', 21121, 'Malmö', '', true, true, '2019-12-12', '2019-12-12'), 
(2, 'pal@pal.com', 'Pål', 'Pålsson', 'Gatugatan 4A', 21121, 'Malmö', '', false, false, '2010-12-12', '2019-12-12'),
(3, 'steve@steve.com', 'Steve', 'Stevesson', 'Gatugatan 23A', 12143, 'Stockholm', '', true, true, '2019-12-12', '2020-12-12’'),
(4, 'sabrina@sabrina.com', 'Sabrina', 'Sabrinasson', 'Gatugatan 111A', 21101, 'Helsingborg', '', true, true, '2010-12-12', '2019-12-12');


CREATE table if not exists Produkter (
id int not null auto_increment,
kategoriId int not null,
namn varchar(50) not null,
pris double not null,
inköpsPris double not null,
beskrivning varchar(800) not null,
bild varchar(100) not null,
skapad date not null,
editerad date not null,
vikt double not null,


primary key (id),
foreign key (kategoriId) references Kategori(id)
);

insert into Produkter (kategoriId, namn, pris, inköpsPris, beskrivning, bild, skapad, editerad, vikt) values
(5, 'Fjällräven Backpack', 109.95, 40.00,
 'Your perfect pack for everyday use and walks in the forest.
 Stash your laptop (up to 15 inches) in the padded sleeve, your everyday', 'https:\/\/picsum.photos\/500?random=1',
 '2021-03-29', '2021-03-29', 0.8),
 
(4, 'Mens Casual T-shirts', 22.0, '10.00',
'Slim-fitting style, contrast raglan long sleeve, three-button henley placket,
light weight & soft fabric for breathableand comfortable wearing.
And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans.
The Henley style round neckline includes a three-button placket.', 'https:\/\/picsum.photos\/500?random=2', '2021-03-29',
'2021-03-29', 0.135),

(4, 'Mens Cotton Jacket', 55.99, 10.00,
'great outerwear jackets for Spring\/Autumn\/Winter, suitable for many occasions,
such as working, hiking, camping, mountain\/rock climbing, cycling, traveling or other outdoors.
 Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.',
 'https:\/\/picsum.photos\/500?random=3', '2021-03-29', '2021-03-29', 2.5),
 
(4, 'Mens Casual Slim Fit', 15.99, 3.99, 'The color could be slightly different between on the screen and in practice.
  Please note that body builds vary by person, therefore, detailed size information should be reviewed below on the product description.',
  'https:\/\/picsum.photos\/500?random=4', '2021-03-29', '2021-03-29', 0.2),
  
(4, 'John Hardy Chain Bracelet', 695.00, 421.21,
 'From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the oceans pearl.
 Wear facing inward to be bestowed with love and abundance, or outward for protection.',
 'https:\/\/picsum.photos\/500?random=5', '2021-03-29', '2021-03-29', 0.5),
 
 (3, 'Solid Gold Petite Micropave', 168.00, 87.50, 'Satisfaction Guaranteed. Return or exchange any order within 30 days.
 Designed and sold by Hafeez Center in the United States. Satisfaction Guaranteed. Return or exchange any order within 30 days.',
 'https:\/\/picsum.photos\/500?random=6', '2021-03-29', '2021-03-29', 0.14596),
 
 (3, 'White Gold Plated Princess', 9.99, 3.30, 'Classic Created Wedding Engagement Solitaire Diamond Promise Ring for Her.
 Gifts to spoil your love more for Engagement, Wedding, Anniversary, Valentines Day...',
 'https:\/\/picsum.photos\/500?random=7', '2021-03-29', '2021-03-29', 0.01),
 
 (3, 'Pierced Owl Gold Plated', 10.99, 3.90, 'Rose Gold Plated Double Flared Tunnel Plug Earrings. Made of 316L Stainless Steel',
 'https:\/\/picsum.photos\/500?random=8', '2021-03-29', '2021-03-29', 0.02),
 
 (5, 'WD 2TB Portable Hard Drive', 64.00, 40.00, 'USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance
 High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7; Reformatting may be required for other operating systems;
 Compatibility may vary depending on user’s hardware configuration and operating system',
 'https:\/\/picsum.photos\/500?random=9', '2021-03-29', '2021-03-29', 1.75),
 
 (3, 'SanDisk SSD 1TB SSD', 109.00, 30.50, 'Easy upgrade for faster boot up, shutdown, application load
 and response (As compared to 5400 RPM SATA 2.5” hard drive; Based on published specifications and internal benchmarking tests using PCMark vantage scores)
 Boosts burst write performance, making it ideal for typical PC workloads The perfect balance of performance and reliability
 Read\/write speeds of up to 535MB\/s\/450MB\/s (Based on internal testing; Performance may vary depending upon drive capacity, host device, OS and application.)',
 'https:\/\/picsum.photos\/500?random=10', '2021-03-29', '2021-03-29', 0.83),
 
 (2, 'Silicon Power 256GB SSD', 109.00, 50.23, '3D NAND flash are applied to deliver high transfer speeds Remarkable transfer speeds that enable faster
 bootup and improved overall system performance. The advanced SLC Cache Technology allows performance boost and longer lifespan 7mm slim design suitable for 
 Ultrabooks and Ultra-slim notebooks. Supports TRIM command, Garbage Collection technology, RAID, and ECC (Error Checking & Correction) to provide the optimized performance and enhanced reliability.',
 'https:\/\/picsum.photos\/500?random=11', '2021-03-29', '2021-03-29', 0.43),
 
(1, 'WD 4TB Gaming Hard Drive', 114, 60.50,
 'Expand your PS4 gaming experience, Play anywhere Fast and easy, setup Sleek design with high capacity, 3-year manufacturers limited warranty',
 'https:\/\/picsum.photos\/500?random=12', '2021-03-29', '2021-03-29', 3.23),

(2, 'Acer SB220Q Full HD', 599, 301, '21.5 inches Full HD (1920 x 1080) widescreen IPS display And Radeon free Sync technology.
 No compatibility for VESA Mount Refresh Rate=> 75Hz - Using HDMI port Zero-frame design | ultra-thin | 4ms response time | IPS panel Aspect ratio - 16=> 9. Color Supported - 16. 7 million colors.
 Brightness - 250 nit Tilt angle -5 degree to 15 degree. Horizontal viewing angle-178 degree. Vertical viewing angle-178 degree 75 hertz', 'https:\/\/picsum.photos\/500?random=13', '2021-03-29', '2021-03-29', 7.77),

(1, 'Samsung 49-Inch QLED', 999.99, 720, '49 INCH SUPER ULTRAWIDE 32=>9 CURVED GAMING MONITOR with dual 27 inch screen side by side QUANTUM DOT (QLED) TECHNOLOGY, HDR support and factory calibration
 provides stunningly realistic and accurate color and contrast 144HZ HIGH REFRESH RATE and 1ms ultra fast response time work to eliminate motion blur, ghosting, and reduce input lag',
 'https:\/\/picsum.photos\/500?random=14', '2021-03-29', '2021-03-29', 25.00),

(3, '3-in-1 Snowboard Jacket', 56.99, 20.50, 'Note: The Jackets is US standard size, Please choose size as your usual wear Material=> 100% Polyester; Detachable Liner Fabric=> Warm Fleece.
 Detachable Functional Liner=> Skin Friendly, Lightweigt and Warm.Stand Collar Liner jacket, keep you warm in cold weather. Zippered Pockets=> 2 Zippered Hand Pockets, 2 Zippered Pockets on Chest
 (enough to keep cards or keys)and 1 Hidden Pocket Inside.Zippered Hand Pockets and Hidden Pocket keep your things secure. Humanized Design=> Adjustable and Detachable Hood and Adjustable cuff to 
 prevent the wind and water,for a comfortable fit. 3 in 1 Detachable Design provide more convenience, you can separate the coat and inner as needed, or wear it together.
 It is suitable for different season and help you adapt to different climates',
 'https:\/\/picsum.photos\/500?random=15', '2021-03-29', '2021-03-29', 2.1),

(4, 'Lock and Love Biker Jacket', 29.95, 10.00, '100% POLYURETHANE(shell) 100% POLYESTER(lining) 75% POLYESTER 25% COTTON (SWEATER), Faux leather material for style and comfort \/ 2 pockets of front,
 2-For-One Hooded denim style faux leather jacket, Button detail on waist \/ Detail stitching at sides, HAND WASH ONLY \/ DO NOT BLEACH \/ LINE DRY \/ DO NOT IRON',
 'https:\/\/picsum.photos\/500?random=16', '2021-03-29', '2021-03-29', 1.8),

(5, 'Rain Jacket Windbreaker', 39.99, 20.00, 'Lightweight perfet for trip or casual wear---Long sleeve with hooded, adjustable drawstring waist design. Button and zipper front closure raincoat,
 fully stripes Lined and The Raincoat has 2 side pockets are a good size to hold all kinds of things, it covers the hips, and the hood is generous but doesnt overdo it.
 Attached Cotton Lined Hood with Adjustable Drawstrings give it a real styled look.',
 'https:\/\/picsum.photos\/500?random=17', '2021-03-29', '2021-03-29', 1.67),

(2, 'MBJ Solid Short Sleeve', 9.85, 2.00, '95% RAYON 5% SPANDEX, Made in USA or Imported, Do Not Bleach,
 Lightweight fabric with great stretch for comfort, Ribbed on sleeves and neckline \/ Double stitching on bottom hem',
 'https:\/\/picsum.photos\/500?random=18', '2021-03-29', '2021-03-29', 0.3),

(3, 'Opna Short Sleeve Moisture', 7.95, 4.00, '100% Polyester, Machine wash, 100% cationic polyester interlock, Machine Wash & Pre Shrunk for a Great Fit, Lightweight,
 roomy and highly breathable with moisture wicking fabric which helps to keep moisture away, Soft Lightweight Fabric with comfortable V-neck collar and a slimmer fit,
 delivers a sleek, more feminine silhouette and Added Comfort',
 'https:\/\/picsum.photos\/500?random=19', '2021-03-29', '2021-03-29', 0.25),	

(2, 'DANVOUY Womens T-Shirt', 12.99, 6, '95%Cotton,5%Spandex, Features=> Casual, Short Sleeve, Letter Print,V-Neck,Fashion Tees, The fabric is soft and has some stretch.
, Occasion=> Casual\/Office\/Beach\/School\/Home\/Street. Season=> Spring,Summer,Autumn,Winter.',
 'https:\/\/picsum.photos\/500?random=20', '2021-03-29', '2021-03-29', 0.37);
 
 
 
 
 
 CREATE table if not exists Produktrabatt (
 id int not null auto_increment,
 produktId int not null,
 rabattProcent int not null,
 startDatum date,
 slutDatum date,
 skapad date not null,
 editerad date not null,
 
 primary key (id),
 foreign key (produktId) references Produkter(id)
 );
 
 insert into Produktrabatt (produktId, rabattProcent, startDatum, slutDatum, skapad, editerad) values
 (1, 5, '2021-04-07', '2021-04-10', '2021-04-07', '2021-04-07'),
 (3, 11, '2021-04-20', '2021-04-25', '2021-04-07', '2021-04-07'),
 (4, 3, '2021-04-13', '2021-04-15', '2021-04-07', '2021-04-07'),
 (2, 2, '2021-04-14', '2021-04-16', '2021-04-07', '2021-04-07');
 
 
 CREATE table if not exists Admins (
 id int not null auto_increment,
 användarNamn varchar(50) not null,
 användarLösen varchar(50) not null,
 
 primary key (id)
 );
 
 insert into Admins (användarNamn, användarLösen) values
 ('hakim', 'Hakim123');
 
 
 CREATE table if not exists Lager (
 id int not null auto_increment,
 produktId int not null,
 saldo int,
 skapad date not null,
 redigerad date not null,
 
 primary key (id),
 foreign key (produktId) references Produkter(id)
 );
 
 insert into Lager (produktId, saldo, skapad, redigerad) values
(1, 200, '2021-04-07', '2021-04-07'),
(2, 40, '2021-04-07', '2021-04-07'),
(3, 10, '2021-04-07', '2021-04-07'),
(4, 0, '2021-04-07', '2021-04-07'),
(5, 25, '2021-04-07', '2021-04-07'),
(6, 34, '2021-04-07', '2021-04-07'),
(7, 22, '2021-04-07', '2021-04-07'),
(8, 11, '2021-04-07', '2021-04-07'),
(9, 4, '2021-04-07', '2021-04-07'),
(10, 5, '2021-04-07', '2021-04-07'),
(11, 77, '2021-04-07', '2021-04-07'),
(12, 123, '2021-04-07', '2021-04-07'),
(13, 25, '2021-04-07', '2021-04-07'),
(14, 77, '2021-04-07', '2021-04-07'),
(15, 5, '2021-04-07', '2021-04-07'),
(16, 2, '2021-04-07', '2021-04-07'),
(17, 1, '2021-04-07', '2021-04-07'),
(18, 37, '2021-04-07', '2021-04-07'),
(19, 66, '2021-04-07', '2021-04-07'),
(20, 33, '2021-04-07', '2021-04-07');


 CREATE table if not exists orderRabatt (
 id int not null auto_increment,
 procent int not null,
 startDatum date not null,
 slutDatum date not null,
 skapad date not null,
 redigerad date not null,
 
 primary key (id)
 );
 
 
 
insert into orderRabatt (procent, startDatum, slutDatum, skapad, redigerad) values
(2, '2021-04-10', '2021-04-12', '2021-04-12', '2021-04-12'),
(3, '2021-04-07', '2021-04-09', '2021-04-12', '2021-04-12'),
(5, '2021-04-13', '2021-04-15', '2021-04-12', '2021-04-12'),
(7, '2021-04-16', '2021-04-20', '2021-04-12', '2021-04-12');



CREATE table if not exists Ordrar (
id int not null auto_increment,
kundId int not null,
orderStatus int not null,
orderRabattId int not null,
skapad date not null,
redigerad date not null,

primary key (id),
foreign key (kundId) references Kunder(id),
foreign key (orderRabattId) references orderRabatt(id)
);

insert into Ordrar (kundId, orderStatus, orderRabattId, skapad, redigerad) values
(1, 4, 2, '2021-04-10', '2021-04-10'),
(2, 1, 1, '2021-04-12', '2021-04-12'),
(3, 2, 3, '2021-04-12', '2021-04-12'),
(4, 3, 4, '2021-04-11', '2021-04-11');




 CREATE table if not exists Innehåller (
 id int not null auto_increment,
 orderId int not null,
 produktId int not null,
 antal int not null,
 skapad date not null,
 redigerad date not null,
 
 primary key (id),
 foreign key (orderId) references Ordrar(id),
 foreign key (produktId) references Produkter(id)
 );
 
 
 insert into Innehåller (orderId, produktId, antal, skapad, redigerad) values 
 (1, 4, 3, '2021-04-12', '2021-04-12'),
 (2, 2, 1, '2021-04-11', '2021-04-11'),
 (3, 3, 2, '2021-04-12', '2021-04-12'),
 (4, 1, 1, '2021-04-12', '2021-04-12');
 
 
 
