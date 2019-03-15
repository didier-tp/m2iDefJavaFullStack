

self.addEventListener('install', function(event) {
console.log('[ServiceWorker] install ***');
});

self.addEventListener('activate', function(event) {
	console.log('[ServiceWorker] activate ***');
});

self.addEventListener('fetch', function(event) {
	console.log('[ServiceWorker] fetch ***');
});
