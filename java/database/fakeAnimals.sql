BEGIN TRANSACTION;

INSERT INTO pets(
	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Mr. Peter', 'https://bestfriends.org/sites/default/files/styles/hero_dashboard_650/public/hero-dash/Victory3427MW_Dashboard_Standard.jpg?h=b02ff9d2&itok=yY9Xr3fe', 'false', 'Rabbit', 'Male', 'Unknown', '3', 'This fella is cuddly');

INSERT INTO pets(
	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Saul', 'https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2023-03/puppy-dog-mc-230321-03-b700d4.jpg', 'true', 'Dog', 'Male', 'Corgi', '4', 'Loves bacon and walks');

INSERT INTO pets(
	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Biscuits', 'https://www.rd.com/wp-content/uploads/2021/04/GettyImages-1288861082-scaled.jpg?resize=696,464', 'false', 'Cat', 'Male', 'House Cat', '2', 'Has fishy breath but is cute');

INSERT INTO pets(
	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Butter', 'https://patch.com/img/cdn20/getty/25204965/20211221/061842/styles/patch_image/public/gettyimages-1221884124___21180650218.jpg', 'false', 'Guinea Pig', 'Male', 'Unknown', '1', 'Might sniff you a lot');

                                    -- More Pets to Add Later!

--INSERT INTO pets(
--	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
--	VALUES ('Tank', 'https://files.slack.com/files-pri/T0GNFLF6D-F053EUXQCBS/image.png', 'false', 'Dog', 'Male', 'Lab Mix', '1', 'Has amazing energy, slight tennis ball addiction');
--
--INSERT INTO pets(
--	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
--	VALUES ('Happy', 'https://files.slack.com/files-pri/T0GNFLF6D-F0533Q58KCH/image.png', 'true', 'Cat', 'Female', 'Unknown', '1', 'Loves sunshine and polka dots');
--
--INSERT INTO pets(
--	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
--	VALUES ('Blue', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQZGZXfcALhaG7pwafvCnUQG5Bq9EZ5_Dh9xRNTHseS4Oi8q3wujkvpfZB8KxF2bdrryQ&usqp=CAU', 'false', 'Bird', 'Male', 'Parakeet', '2', 'Loves good conversations');
--
--INSERT INTO pets(
--	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
--	VALUES ('Jams', 'https://c4.wallpaperflare.com/wallpaper/12/91/646/cocker-spaniel-wallpaper-preview.jpg', 'true', 'Dog', 'female', 'Spaniel', '1', 'Musically talented, prefers pop rock);
--

COMMIT TRANSACTION;