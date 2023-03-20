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
       getProduct().then(res => {
           this.products = res.data
       })
    },
    methods: {
        async initProp(){
          await this.callGetProuct()
          await  this.onsiteImg
        },
        callGetProuct(){
            getProduct().then(res => {
                this.products = res.data
            })
        },
        onsiteImg(){
            const img = document.getElementById('myImg');
            img.onload = function() {
                const imgWidth = img.naturalWidth;
                const imgHeight = img.naturalHeight;
                const containerWidth = img.parentElement.clientWidth;
                const containerHeight = img.parentElement.clientHeight;
                const widthRatio = imgWidth / containerWidth;
                const heightRatio = imgHeight / containerHeight;
                const ratio = Math.max(widthRatio, heightRatio);
                const newWidth = imgWidth / ratio;
                const newHeight = imgHeight / ratio;
                img.style.width = newWidth + 'px';
                img.style.height = newHeight + 'px';
                img.style.marginLeft = (containerWidth - newWidth) / 2 + 'px';
                img.style.marginTop = (containerHeight - newHeight) / 2 + 'px';
        }
    }
}
}
