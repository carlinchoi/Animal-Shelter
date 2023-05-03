<template>
  <q-layout>
    <q-page-container class="q-gutter-md">
      <q-page class="add-wrapper">
        <div class="form-wrapper">
          <div id="register">
            <q-form @submit.prevent="register"  v-if="!showVolunteerApplication">
              <div class="my-inputs">
                <h3
                  style="font-weight: bold; margin-bottom: 1%; margin-top: 1%"
                >
                Create Volunteer Account
                </h3>

                <q-separator />

                <div class="input-container">
                  <p style="font-weight: bold; margin-bottom: 1%">Username</p>
                  <q-input
                    filled
                    v-model="user.username"
                    label="Username"
                    type="text"
                    required
                    style="width: 100%"
                  >
                    <template v-slot:prepend>
                      <q-icon name="person" />
                    </template>
                  </q-input>
                </div>
                <div class="input-container">
                  <p style="font-weight: bold; margin-bottom: 1%">Password</p>
                  <q-input
                    filled
                    v-model="user.password"
                    label="Password"
                    type="password"
                    required
                    style="width: 100%"
                  >
                    <template v-slot:prepend>
                      <q-icon name="lock" />
                    </template>
                  </q-input>
                </div>
                <div class="input-container">
                  <p style="font-weight: bold; margin-bottom: 1%">Confirm Password</p>
                  <q-input
                    filled
                    v-model="user.confirmPassword"
                    label="Confirm Password"
                    type="password"
                    required
                    style="width: 100%"
                  >
                    <template v-slot:prepend>
                      <q-icon name="lock" />
                    </template>
                  </q-input>
                </div>
                <div
                  class="input-container"
                  style="display: flex; justify-content: space-between"
                >
                  <q-btn
                    class="q-mt-md"
                    label="Cancel"
                    color="negative"
                    @click="$router.push('/')"
                    size="lg"
                    style="flex-grow: 0.97"
                  />
                  <q-btn
                    type="submit"
                    class="q-mt-md"
                    label="Submit"
                    color="primary"
                    size="lg"
                    style="flex-grow: 0.97"
                  />
                </div>
              </div>
              <div role="alert" v-if="registrationErrors">
              {{ registrationErrorMsg }}
            </div>
            </q-form>
          </div>
        </div>
        <volunteer-application
      v-if="showVolunteerApplication"
      v-bind:username="user.username"
    />
      </q-page>
    </q-page-container>
  </q-layout>
</template>

<script>
import authService from "../boot/AuthService";
// import VolunteerApplication from "../components/VolunteerApplication.vue";

export default {
  name: "volunteerRegister",
  components: {
    // VolunteerApplication,
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "PENDINGVOLUNTEER",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
      showVolunteerApplication: false,
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "*Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.showVolunteerApplication = true;
              this.$router.push({
                name: 'newVolunteer',
                query: { registration: 'success' },
                params: { username: this.user.username }
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "*There were problems registering this user.";
    },
  },
};
</script>
