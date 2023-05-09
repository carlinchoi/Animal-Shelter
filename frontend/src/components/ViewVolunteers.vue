<!-- <template>
  <div id="q-app" style="min-height: 100vh; margin-top: 3%">
    <div class="q-pa-md">
      <q-table
        class="my-sticky-header-column-table"
        flat
        bordered
        title="Volunteers"
        :data="filteredVolunteers"
        :columns="columns"
        row-key="email"
        :pagination="pagination"
        @update:pagination="(val) => (pagination = val)"
        :rows-per-page-options="[10, 15, 20]"
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
      console.log("retrieveVolunteers method called");
      this.loading = true;
      VolunteerService.findAllVolunteer()
        .then((response) => {
          this.$store.commit("SET_VOLUNTEER_INFO", response.data);
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
      console.log(this.$store.state.volunteers, " this.$store.state.volutneers volunteers computed")
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
</script> -->

<!-- <template>
  <div id="q-app" style="min-height: 100vh;">
    <div class="q-pa-md">
      <q-table
        class="my-sticky-dynamic"
        flat bordered
        title="Volunteers"
        :rows="rows"
        :columns="columns"
        :loading="loading"
        row-key="index"
        virtual-scroll
        :virtual-scroll-item-size="48"
        :virtual-scroll-sticky-size-start="48"
        :pagination="pagination"
        :rows-per-page-options="[0]"
        @virtual-scroll="onScroll"
      ></q-table>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  computed: {
    ...mapState({
      volunteers: state => state.volunteers,
    }),
    columns: [
      {
        name: 'index',
        label: '#',
        field: 'index',
      },
      {
        name: 'firstName',
        required: true,
        label: 'First Name',
        align: 'left',
        field: 'firstName',
        format: val => val,
        sortable: true,
      },
      {
        name: 'lastName',
        align: 'center',
        label: 'Last Name',
        field: 'lastName',
        sortable: true,
      },
      {
        name: 'email',
        label: 'Email',
        field: 'email',
        sortable: true,
      },
      {
        name: 'phone',
        label: 'Phone',
        field: 'phone',
      },
      {
        name: 'role',
        label: 'Role',
        field: 'role',
      },
    ],
    seed: [],
  },
  methods: {
    generateSeed() {
      this.seed = this.volunteers.map((volunteer, index) => ({
        index: index + 1,
        firstName: volunteer.firstName,
        lastName: volunteer.lastName,
        email: volunteer.email,
        phone: volunteer.phone,
        role: volunteer.role,
      }));
    },
  },
  mounted() {
    this.generateSeed();
  },
  watch: {
    volunteers() {
      this.generateSeed();
    },
  },
};
</script> -->

<!-- <template>
  <div id="q-app" style="min-height: 100vh; margin-top: 3%">
    <div class="q-pa-md">
      <q-table
        class="my-sticky-header-column-table"
        flat
        bordered
        title="Volunteers"
        :data="filteredVolunteers"
        :columns="columns"
        row-key="email"
        :pagination="pagination"
        @update:pagination="(val) => (pagination = val)"
        :rows-per-page-options="[10, 15, 20]"
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
        <template v-slot:body="props">
          <q-tr :props="props">
            <q-td v-for="col in columns" :key="col.name" :props="props">
              {{ props.row[col.field] }}
            </q-td>
          </q-tr>
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
      console.log("retrieveVolunteers method called");
      this.loading = true;
      VolunteerService.findAllVolunteer()
        .then((response) => {
          this.$store.commit("SET_VOLUNTEER_INFO", response.data);
console.log(this.$store.state.volunteers, "TEST");

          console.log(response.data, "response.data")
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
    console.log(this.$store.state.volunteers, "coonsole.log(this.$store.state.volunteers)")

    return this.$store.state.volunteers;
    },
  filteredVolunteers() {
    let filtered = this.volunteers;
    console.log(this.volunteers, "volunteers")
    console.log(filtered + "filtered computed")

    if (this.searchTerm) {
  filtered = filtered.filter(
    (volunteer) => {
      const match =
        volunteer.firstName.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        volunteer.lastName.toLowerCase().includes(this.searchTerm.toLowerCase());
      console.log(volunteer, match);
      console.log("filtered is being called")
      return match;
    }
  );
}
    // if (this.selectedRole) {
    //   filtered = filtered.filter(
    //     (volunteer) => volunteer.role === this.selectedRole
    //   );
    // }
    return filtered;
  },
  rowsPerPageTemplate() {
    return this.pagination.rowsPerPage === -1
      ? this.$q.lang.label.displayAll
      : this.pagination.rowsPerPage.toString();
  },
},
watch: {
  "$store.state.volunteers": {
    handler: function() {
      // Force re-computation of filteredVolunteers
      this.$forceUpdate();
    },
    deep: true
  }
},

  created() {
    this.retrieveVolunteers();

  },
};
</script> -->

<template>
  <div id="q-app" style="min-height: 100vh">
    <div class="q-pa-md">
      <q-table
        class="my-sticky-header-table"
        flat
        bordered
        title="Volunteers"
        :rows="volunteers"
        :columns="columns"
        row-key="volunteer.email"
      ></q-table>
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
        // {
        //   name: "name",
        //   required: true,
        //   label: "First Name",
        //   align: "left",
        //   field: (row) => row.name,
        //   format: (val) => `${val}`,
        //   sortable: true,
        // },
        {
          name: "firstName",
          required: true,
          label: "First Name",
          align: "left",
          field: "firstName",
          sortable:true,
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

<style>
.my-sticky-header-table {
  /* height or max-height is important */
  margin-top: 3%;
}
.q-table__top,
.q-table__bottom,
thead tr:first-child th {
  /* bg color is important for th; just specify one */
  background-color: #00b4ff;
}

thead tr th {
  position: sticky;
  z-index: 1;
}

thead tr:first-child th {
  top: 0;
}

/* this is when the loading indicator appears */
.q-table--loading thead tr:last-child th {
  /* height of all previous header rows */
  top: 48px;
}

/* prevent scrolling behind sticky top row on focus */
tbody {
  /* height of all previous header rows */
  scroll-margin-top: 48px;
}
</style>
