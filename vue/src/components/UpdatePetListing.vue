<template>
  <body>
    <div class="login-wrapper">
      <div>
        <div class="form-wrapper">
          <form @submit.prevent="updatePet">
            <h1>Update Pet Listing</h1>
            <div class="form-input-group">
              <input
                type="text"
                placeholder="Name"
                v-model="pet.petName"
                required
              />
            </div>
            <div class="form-input-group">
              <input
                type="text"
                placeholder="Species"
                v-model="pet.species"
                required
              />
            </div>
            <div class="form-input-group">
              <input
                type="text"
                placeholder="Gender"
                v-model="pet.gender"
                required
              />
            </div>
            <div class="form-input-group">
              <input
                type="text"
                placeholder="Breed"
                v-model="pet.breed"
                required
              />
            </div>
            <div class="form-input-group">
              <input
                type="number"
                placeholder="Age"
                v-model="pet.age"
                required
              />
            </div>
            <div class="form-input-group">
              <input
                type="text"
                placeholder="Description"
                v-model="pet.description"
                required
              />
            </div>
            <div class="form-input-group">
              <input
                type="url"
                placeholder="Photo URL"
                v-model="pet.petPhoto"
                required
              />
            </div>
            <div class="form-input-group">
              <label for="is adopted"> Has this pet been adopted? </label>
              <input type="checkbox" v-model="pet.adopted" />
            </div>
            <button type="submit">Submit Updated Listing</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import petService from "../services/PetService.js";
export default {
  name: "update-pet-listing",
  props: ["petId"],
  //pet: Object,
  data() {
    return {
      pet: {
        petId: this.petId,
        petName: "",
        species: "",
        adoptionDate: null,
        gender: "",
        breed: "",
        age: "",
        description: "",
        petPhoto: "",
        adopted: "",
      },
    };
  },
  methods: {
    updatePet() {
      petService
        .updatePet(this.petId, this.pet)
        .then((response) => {
          if (response.status == 200) {
            if (this.pet.adopted === true) {
              this.$router.push({
                name: "adoption-form-page",
                params: { petId: this.petId, petName: this.pet.petName}
              });
            } else {
              this.$router.push({
                path: "/",
              });
            }
          }
        })
        .catch((error) => {
          const response = error.response;
          this.registrationErrors = true;
          if (response.status === 400) {
            this.registrationErrorMsg = "Bad Request: Validation Errors";
          }
        });
    },
  },
  created() {
    petService
      .getPetById(this.petId)
      .then((response) => {
        this.$store.commit("SET_ACTIVE_PET", response.data);
        this.pet = response.data;
        //this.pet.species = response.data.pet.species;
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });
    //this.pet = this.$route.params.pet;
  },
};
</script>

<style scoped>
label {
  border: 1px solid black;
  background: #62a18f;
  padding: 5px;
  color:white;
  border-radius: 10px;
}
h1 {
  border: 1px solid black;
  background: #62a18f;
  padding: 20px;
  border-radius: 50%;
  color:white;
}
body {
  min-height: 100%;
  min-width: 100%;
  margin: 0;
  padding: 0;
}
form {
  background-image: url("../assets/background2.png");
  background-color: rgb(224, 212, 238);
  background-size: contain;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin-top: 20vh;
  max-width: 400px;
  margin: auto;
  padding: 80px;
  border: 2px solid #410553;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
}
.form-input-group {
  margin-bottom: 1rem;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.form-input-group .icon {
  width: 30px;
  align-self: flex-start;
  margin-right: -10px;
}
label {
  width: 100px;
  margin-right: 0.5rem;
  font-weight: bold;
  color: white;
  margin-top: -10px;
}
input {
  flex: 1;
  padding: 0.5rem;
  border: 2px solid #ccc;
  border-radius: 5px;
  justify-self: left;
  padding: 10px;
  border-radius: 10px;
}
button {
  min-width: 130px;
  height: 40px;
  color: #fff;
  padding: 5px 20px;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
  outline: none;
  border-radius: 20px;
  border: 2px solid #4c6e5c;
  background: #62a18f;
  margin-top: 0px;
}
button:hover {
  background: #fff;
  color: #fff;
}
.login-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
body {
  overflow: hidden;
}
h1 {
  color: white;
}
</style>
