BEGIN TRANSACTION;

INSERT INTO pets(
	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Mr. Peter', 'https://bestfriends.org/sites/default/files/styles/hero_dashboard_650/public/hero-dash/Victory3427MW_Dashboard_Standard.jpg?h=b02ff9d2&itok=yY9Xr3fe', 'false', 'Rabbit', 'Male', 'Unknown', '3', 'This fella is cuddly');

INSERT INTO pets(
	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Saul', 'https://media-cldnry.s-nbcnews.com/image/upload/rockcms/2023-03/puppy-dog-mc-230321-03-b700d4.jpg', 'true', 'Dog', 'Male', 'Corgi', '4', 'Loves bacon and walks');

INSERT INTO pets(
	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Biscuits', 'https://patch.com/img/cdn20/getty/25204965/20211221/061842/styles/patch_image/public/gettyimages-1221884124___21180650218.jpg', 'false', 'Cat', 'Female', 'House Cat', '2', 'Has fishy breath but is cute');

INSERT INTO pets(
	pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description)
	VALUES ('Butter', 'https://patch.com/img/cdn20/getty/25204965/20211221/061842/styles/patch_image/public/gettyimages-1221884124___21180650218.jpg', 'false', 'Guinea Pig', 'Male', 'Unknown', '1', 'Might sniff you a lot');



COMMIT TRANSACTION;