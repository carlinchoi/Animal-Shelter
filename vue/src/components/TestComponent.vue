<template>
   <table>
    <thead>
      <tr>
        <th>&nbsp;</th>
        <th>Pet id</th>
        <th>Pet Name</th>
        <th>Gender</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="pet in pets" :key="pet.pet_id" >
        <td >{{pet.pet_id}}</td>
        <td> {{pet.pet_name}}</td>
        <td>{{gender}}</td>
      </tr>
    </tbody>
  </table>
</template>
<script>
import  petService  from "../services/PetService"
export default {
    name:"test-component",
    data(){
        return{
            pets:[]
        }
    },
    created(){
        petService.findAllPets().then((response)=>{
            this.pets=response.data;
        })
    }
}
</script>
<style>
</style>