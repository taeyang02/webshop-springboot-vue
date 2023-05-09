<template>
<navBar/>
<div class="container">
  <div class="row">
    <div class="col-sm-3" v-for="product in products">
      <div class="card" style="width: 18rem;">
        <img :src="`/images/${product.image}`" class="responsive-image-fit">
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
  <pagination
      :next-page="nextPage"
      :previous-page="previousPage"
      :total-pages="totalPages"
      :current-page="currentPage"
  />
</div>
  <lineFooter/>
</template>
<script>
import homepages from '@/user/homepage'
import pagination from '@/utils/pagination.vue'
export default {
  components: {pagination},
  mixins:[homepages],
}

</script>

<style scoped>
.card {
  margin-top: 25px;
}

.card-text {
  display: -webkit-box;
  -webkit-line-clamp: 1;
  -webkit-box-orient: vertical;
  overflow: hidden;
  white-space: normal;
  text-overflow: ellipsis;
}

.product.button a {
  margin-right: 10px;
  padding: 10px 20px;
}
.responsive-image-fit {
  width: 100%;
  height: 300px;
  object-fit: cover; /* hoặc contain */
}

</style>


