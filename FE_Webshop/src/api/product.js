import response from '@/api/baseAPI/api_call_be';

 export function getProduct(params) {
    return response.get("products",{
        params:params
    })
}
