import { getProduct } from '@/api/product'
import menuNav from "@/components/commom/menu.vue";
import lineFooter from "@/components/commom/footer.vue";
export default {
    name: "homepage",
    components:{
      navBar: menuNav,
        lineFooter
    },
    data(){
        return{
            products: [],
            currentPage: 0,
            totalPages: 0,
        }
    },
    created() {
        this.callGetProuct()
    },
    methods: {
        callGetProuct(params){
            getProduct(params).then(res => {
                console.log(res.data)
                this.products = res.data.result
                this.currentPage = res.data.pageNumber+1
                this.totalPages = res.data.totalPages
            })
        },
        nextPage() {
            this.currentPage++
            if (this.currentPage > this.totalPages) this.currentPage = 1
            this.callGetProuct({page: this.currentPage - 1 })
        },
        previousPage() {
            this.currentPage--
            if (this.currentPage === 0) this.currentPage = this.totalPages
            this.callGetProuct({page: this.currentPage - 1 })
        }
}
}
