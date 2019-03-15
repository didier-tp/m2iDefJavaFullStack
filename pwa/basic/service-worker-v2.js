
importScripts('../lib/workbox.3.6.1.js');
if (workbox) {
console.log('Good! Workbox is loaded');
} else {
console.log('Bad! Workbox did not load');
}

workbox.routing.registerRoute(
new RegExp('.*\.js'),
workbox.strategies.networkFirst()
);

workbox.precaching.precache([
  {
    url: '/index.html',
    revision: '2',
  }, {
    url: '/service-worker.js',
    revision: '2',
  },
  {
    url: '/lib/workbox.3.6.1.js.js',
    revision: '2',
  }
]);
workbox.precaching.addRoute();

workbox.routing.registerRoute(
new RegExp('.*\.html'),
workbox.strategies.cacheFirst()
);

workbox.routing.registerRoute(
new RegExp('.*\.json'),
workbox.strategies.networkFirst()
);

workbox.routing.registerRoute(
// Cache CSS files
/.*\.css/,
// Use cache but update in the background ASAP
workbox.strategies.staleWhileRevalidate({
// Use a custom cache name
cacheName: 'css-cache',
})
);

workbox.routing.registerRoute(
// Cache image files
/.*\.(?:png|jpg|jpeg|svg|gif)/,
// Use the cache if it's available
workbox.strategies.cacheFirst({
// Use a custom cache name
cacheName: 'image-cache',
plugins: [
new workbox.expiration.Plugin({
// Cache only 200 images
maxEntries: 200,
// Cache for a maximum of a week
maxAgeSeconds: 7 * 24 * 60 * 60,
})
],
})
);

/*
self.addEventListener('install', function(event) {
console.log('[ServiceWorker] install ***');
});

self.addEventListener('activate', function(event) {
	console.log('[ServiceWorker] activate ***');
});

self.addEventListener('fetch', function(event) {
	console.log('[ServiceWorker] fetch ***');
});
*/