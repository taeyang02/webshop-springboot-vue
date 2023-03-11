<template>
<div class="container">
  <div class="row">
    <div class="col-sm-3" v-for="product in products">
      <div class="card" style="width: 18rem;">
        <img :src="`/images/${product.image}`" style="width: 100%; height: auto">
        <div class="card-body">
          <h5 class="card-title">{{product.name}}</h5>
          <p class="card-text">Mô Tả : {{product.description}}</p>
          <p class="card-text">Giá {{product.price + 'đ'}}</p>
          <p class="card-text">Còn: {{product.quantity + 'Sản phẩm'}}</p>
          <div class="product button">
            <a href="#" class="btn btn-primary">Mua</a>
            <a href="#" class="btn btn-warning">Thêm</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</template>
<script>
export default {
  name: "homepage",
  data(){
    return{
      products: [],
    }
  },
  created() {
    fetch("http://localhost:8080/products")
        .then((response) => response.json())
        .then((data) => this.products = data);
  },
}
</script>

<style scoped>
.product .button {

  margin: 15px;
}
</style>


