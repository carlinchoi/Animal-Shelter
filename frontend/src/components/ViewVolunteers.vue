<template>
  <div id="q-app" style="min-height: 100vh">
    <div class="q-pa-md">
      <div>
        <h2 style="margin-bottom: 0.5rem; margin-top: 3%;">Volunteers List</h2>
        <div>
          <q-input
            v-model="searchTerm"
            outlined
            label="Search Volunteers by First or Last Name"
            clearable
          />
        </div>
        <q-table
          class="my-sticky-header-table"
          flat
          bordered
          :rows="filteredVolunteers"
          :columns="columns"
          row-key="volunteer.email"
        >
        </q-table>
      </div>
    </div>
  </div>
</template>

<script>
import VolunteerService from "../boot/VolunteerService.js";
export default {
  name: "view-volunteers",
  data() {
    return {
      searchTerm: "",
      selectedRole: null,
      columns: [
        {
          name: "firstName",
          required: true,
          label: "First Name",
          align: "left",
          field: "firstName",
          sortable: true,
        },
        {
          name: "lastName",
          required: true,
          label: "Last Name",
          align: "left",
          field: "lastName",
          sortable: true,
        },
        {
          name: "email",
          required: true,
          label: "Email",
          align: "left",
          field: "email",
          sortable: true,
        },
        {
          name: "phone",
          required: true,
          label: "Phone",
          align: "left",
          field: "phone",
          sortable: true,
        },
        {
          name: "role",
          required: true,
          label: "Role",
          align: "left",
          field: "role",
          sortable: true,
        },
      ],
    };
  },
  methods: {
    retrieveVolunteers() {
      VolunteerService.findAllVolunteer().then((response) => {
        this.$store.commit("SET_VOLUNTEER_INFO", response.data);
      });
    },
  },
  computed: {
    volunteers() {
      return this.$store.state.volunteers;
    },
    filteredVolunteers() {
      let filtered = this.volunteers;
      if (this.searchTerm) {
        filtered = filtered.filter(
          (volunteer) =>
            volunteer.firstName
              .toLowerCase()
              .includes(this.searchTerm.toLowerCase()) ||
            volunteer.lastName
              .toLowerCase()
              .includes(this.searchTerm.toLowerCase()) ||
            volunteer.email
              .toLowerCase()
              .includes(this.searchTerm.toLowerCase()) ||
            volunteer.phone
              .toLowerCase()
              .includes(this.searchTerm.toLowerCase())
        );
      }

      if (this.selectedRole) {
        filtered = filtered.filter(
          (volunteer) => volunteer.role === this.selectedRole
        );
      }
      return filtered;
    },
  },
  created() {
    this.retrieveVolunteers();
  },
};
</script>


