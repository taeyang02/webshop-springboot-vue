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
        }
    },
    created() {
        this.callGetProuct()
    },
    methods: {
        callGetProuct(){
            getProduct().then(res => {
                console.log(res)
                this.products = res.data.content
            })
        }
}
}
