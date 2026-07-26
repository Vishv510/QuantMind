/** @type {import('tailwindcss').Config} */
export default {
  darkMode: 'class',
  content: ['./index.html', './src/**/*.{js,ts,jsx,tsx}'],
  theme: {
    extend: {
      colors: {
        brand: {
          50: '#eff6ff',
          600: '#387ED1',
          700: '#2f66b3',
        },
      },
      boxShadow: {
        soft: '0 10px 40px rgba(15, 23, 42, 0.08)',
      },
    },
  },
  plugins: [],
}

