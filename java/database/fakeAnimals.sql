BEGIN TRANSACTION;

INSERT INTO pets(
	pet_name, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Mr. Peter', 'false', 'Rabbit', 'Male', 'Unknown', '3', 'This fella is cuddly');

INSERT INTO pets(
	pet_name, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Saul', 'false', 'Dog', 'Male', 'Corgi', '4', 'Loves bacon and walks');

INSERT INTO pets(
	pet_name, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Biscuits', 'false', 'Cat', 'Male', 'House Cat', '2', 'Has fishy breath but is cute');

INSERT INTO pets(
	pet_name, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Butter', 'false', 'Guinea Pig', 'Male', 'Unknown', '1', 'Might sniff you a lot');

INSERT INTO pets(
	pet_name, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Tank', 'false', 'Dog', 'Male', 'Golden', '1', 'Has amazing energy, slight tennis ball addiction');


INSERT INTO pets(
	pet_name, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Happy','false', 'Cat', 'Female', 'Unknown', '1', 'Loves polka dots');

INSERT INTO pets(
	pet_name, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Blue', 'false', 'Bird', 'Male', 'Parakeet', '2', 'Loves good conversations');

INSERT INTO pets(
	pet_name, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Jams', 'false', 'Dog', 'female', 'Spaniel', '1', 'Musically talented, prefers pop rock');


INSERT INTO pets(
	pet_name, is_adopted, species, gender, breed, age_years, description, adoption_date)
	VALUES ('Nugget', 'true', 'Hamster', 'male', 'Unknown', '3', 'Loves playgrounds and fresh veggies', '11-04-2022');


INSERT INTO pets(
	pet_name, is_adopted, species, gender, breed, age_years, description, adoption_date)
	VALUES ('Cuddles', 'true', 'Hamster', 'female', 'Unknown', '1', 'Requires cozy couch and pillows', '04-03-2023');

INSERT INTO pet_photos (pet_id, photo_url) VALUES (1, 'https://bestfriends.org/sites/default/files/styles/hero_dashboard_650/public/hero-dash/Victory3427MW_Dashboard_Standard.jpg?h=b02ff9d2&itok=yY9Xr3fe');
INSERT INTO pet_photos (pet_id, photo_url) VALUES (2, 'https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2023-03/puppy-dog-mc-230321-03-b700d4.jpg');
INSERT INTO pet_photos (pet_id, photo_url) VALUES (3, 'https://www.rd.com/wp-content/uploads/2021/04/GettyImages-1288861082-scaled.jpg?resize=696,464');
INSERT INTO pet_photos (pet_id, photo_url) VALUES (4, 'https://patch.com/img/cdn20/getty/25204965/20211221/061842/styles/patch_image/public/gettyimages-1221884124___21180650218.jpg');
INSERT INTO pet_photos (pet_id, photo_url) VALUES (5, 'https://people.com/thmb/s5axxuhc4nVAr5YfJ4nyjAxBCrM=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(637x434:639x436)/tennis-ball-dog-1-426a19de798f4044accbbed837b204c6.jpg');
INSERT INTO pet_photos (pet_id, photo_url) VALUES (6, 'https://cdn.shopify.com/s/files/1/0249/6472/6880/products/170106485_924058855021440_6983099715977778192_n.jpg?v=1677208554&width=1445');
INSERT INTO pet_photos (pet_id, photo_url) VALUES (7, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQZGZXfcALhaG7pwafvCnUQG5Bq9EZ5_Dh9xRNTHseS4Oi8q3wujkvpfZB8KxF2bdrryQ&usqp=CAU');
INSERT INTO pet_photos (pet_id, photo_url) VALUES (8, 'https://c4.wallpaperflare.com/wallpaper/12/91/646/cocker-spaniel-wallpaper-preview.jpg');
INSERT INTO pet_photos (pet_id, photo_url) VALUES (9, 'https://en.bcdn.biz/Images/2015/9/18/094344f8-707e-4f31-b24f-c2a51ea3de78.jpg');
INSERT INTO pet_photos (pet_id, photo_url) VALUES (10, 'https://t4.ftcdn.net/jpg/02/70/05/25/360_F_270052571_qP9uVd1MpB4kfflUO92S5gdKYCjxM5K3.jpg');
--INSERT INTO pet_photos (pet_id, photo_url) VALUES (5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEJjN9H-bLwwrbdRegimIKIIkasGrpZBYtFQ&usqp=CAU');
--INSERT INTO pet_photos (pet_id, photo_url) VALUES (6, 'https://hips.hearstapps.com/hmg-prod/images/gettyimages-1144982182.jpg?crop=1.00xw:0.751xh;0,0.166xh&resize=1200:*');


COMMIT TRANSACTION;