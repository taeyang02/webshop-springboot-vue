import respon from '@/api/baseAPI/api_call_be';
 export function getProduct() {
    return respon.get('products');
}
