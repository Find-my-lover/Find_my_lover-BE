//프론트에서 api로 요처을 보내면
//백엔드인 8080포트로 요청이 도착함

const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(
        '/api',
        createProxyMiddleware({
            target: 'http://localhost:8080',
    changeOrigin: true,
})
);
};
