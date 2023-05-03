<template>
  <div id="q-app" style="min-height: 100vh;">
    <div class="q-pa-md">
      <q-table
        class="my-sticky-header-column-table"
        flat bordered
        title="Volunteers"
        :data="filteredVolunteers"
        :columns="columns"
        row-key="email"
        :pagination="pagination" @update:pagination="val => pagination = val"        :rows-per-page-options="[10, 15, 20]"
        :loading="loading"
        :rows-per-page-template="rowsPerPageTemplate"
      >
        <template v-slot:top>
          <q-input
            v-model="searchTerm"
            outlined
            dense
            placeholder="Search by First or Last Name"
            class="q-mb-md"
          />
        </template>
      </q-table>
    </div>
  </div>
</template>

<script>
import VolunteerService from "../boot/VolunteerService.js";

export default {
  name: "view-volunteers",
  data() {
    return {
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
      searchTerm: "",
      selectedRole: null,
      pagination: {
        sortBy: "firstName",
        descending: false,
        page: 1,
        rowsPerPage: 10,
      },
      loading: false,
    };
  },
  methods: {
    retrieveVolunteers() {
  this.loading = true;
  VolunteerService.findAllVolunteer()
    .then((response) => {
      this.volunteers = response.data;
    })
    .catch((error) => {
      console.error(error);
    })
    .finally(() => {
      this.loading = false;
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
    rowsPerPageTemplate() {
      return this.pagination.rowsPerPage === -1
        ? this.$q.lang.label.displayAll
        : this.pagination.rowsPerPage.toString();
    },
  },
  created() {
    this.retrieveVolunteers();
  },
};
</script>
