<template>
  <q-layout>
    <q-page-container class="q-gutter-md">
      <q-page class="add-wrapper">
        <div class="form-wrapper">
          <div id="register">
            <q-form @submit.prevent="login">
              <div class="my-inputs">
                <h3
                  style="font-weight: bold; margin-bottom: 1%; margin-top: 1%"
                >
                  Login
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
                <a
                  class="q-mt-md q-link"
                  @click="$router.push('/register-account')"
                  style="text-decoration: underline; cursor: pointer; margin-top: -1%; font-size:17px; font-weight: bold;"
                >
                  Create New Account
                </a>
                <div
                  class="input-container"
                  style="display: flex; justify-content: space-between; margin-top: -3%; margin-bottom: 0%;"
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

              <div role="alert" v-show="registrationErrors">
                {{ registrationErrorMsg }}
              </div>
            </q-form>
          </div>
        </div>
      </q-page>
    </q-page-container>
  </q-layout>
</template>


<script>
import authService from "../boot/AuthService";
import { QLayout, QPage, QPageContainer, QForm, QInput, QBtn } from "quasar";

export default {
  name: "loginPage",
  components: { QLayout, QPage, QPageContainer, QForm, QInput, QBtn },
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },

  //Reset
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            if (response.data.user.authorities[0].name === "ROLE_APPROVED") {
              this.$router.push("/change-password");
            } else if (
              response.data.user.authorities[0].name === "ROLE_PENDINGVOLUNTEER"
            ) {
              this.$router.push({ name: "pending-application" });
            } else {
              this.$router.push("/");
            }
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
