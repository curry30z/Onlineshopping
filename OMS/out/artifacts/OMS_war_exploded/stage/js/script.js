


// 获取商品推荐列表
let recommendList = document.querySelector('.recommend ul');

// 设置定时器来实现上下滚动
setInterval(() => {
    let firstItem = recommendList.firstElementChild;
    recommendList.style.transition = 'margin-top 0.5s ease-in-out';
    recommendList.style.marginTop = '-100%';
    setTimeout(() => {
        recommendList.appendChild(firstItem);
        recommendList.style.transition = 'none';
        recommendList.style.marginTop = '0';
    }, 500);
}, 10000);