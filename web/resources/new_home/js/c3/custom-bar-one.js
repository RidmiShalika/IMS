var chart6 = c3.generate({
	bindto: '#barGraphOne',
	data: {
		columns: [
			['present', 15, 38, 62,80,50,44,55,44,55],
			['absent', 21, 26, 30,15,38,62,80,55,44],
			
		],
		type: 'bar',
		names: {
			present: 'present',
			absent: 'absent',
			
		},
		colors: {
			present: '#009de4',
			absent: '#ff6a5d',
			
		},
	},
	grid: {
		x: {
			show: true
		},
		y: {
			show: true
		}
	}
});