App({
    globalData: {
        token: ''
    },
    onLaunch: function () {
        var timestamp = new Date().getTime();
        var expiration = wx.getStorageSync("expiration");
        if (expiration && expiration > timestamp) {
            this.globalData.token = wx.getStorageSync("token");
        }
    }
})