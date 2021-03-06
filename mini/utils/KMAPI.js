var API_BASE_URL = 'http://127.0.0.1:8080';

var request = function request(url, method, data) {
    var _url = API_BASE_URL + url;
    return new Promise(function (resolve, reject) {
        wx.request({
            url: _url,
            method: method,
            data: data,
            header: {
                'Content-Type': 'application/json'
            },
            success: function success(request) {
                resolve(request.data);
            },
            fail: function fail(error) {
                reject(error);
            },
            complete: function complete(aaa) {
                // 加载完成
            }
        });
    });
};

/**
 * 小程序的promise没有finally方法，自己扩展下
 */
Promise.prototype.finally = function (callback) {
    var Promise = this.constructor;
    return this.then(function (value) {
        Promise.resolve(callback()).then(function () {
            return value;
        });
    }, function (reason) {
        Promise.resolve(callback()).then(function () {
            throw reason;
        });
    });
};

module.exports = {
    register_complex: function register_complex(data) {
        return request('/wxapp/register', 'POST', data);
    },
    login_wx: function login_wx(data) {
        return request('/wxapp/login/' + data, 'GET', null);
    },
    get_todos: function get_todos(data) {
        return request('/todos/status/' + data.status + '/0/' + data.token, 'GET', null);
    }

}