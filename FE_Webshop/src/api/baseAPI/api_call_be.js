import axios from 'axios';
//testxxxftgcv
const instance = axios.create({
    baseURL: 'https://www.duonghasagi.online/api/products',
    headers: {
        'Content-Type': 'application/json',
        Accept: 'application/json',
    },
    timeout: 5000,
});

instance.interceptors.request.use(
    (config) => {
        // Xử lý trước khi gửi request
        return config;
    },
    (error) => {
        // Xử lý khi request gặp lỗi
        return Promise.reject(error);
    }
);

instance.interceptors.response.use(
    (response) => {
        // Xử lý khi nhận được response
        return response.data;
    },
    (error) => {
        // Xử lý khi response gặp lỗi
        return Promise.reject(error);
    }
);

export default instance;
