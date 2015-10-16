

import java.util.HashSet;
import java.util.Set;

public class LeapYear {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Integer> leap = new HashSet<Integer>();
		initLeap(leap);

		for (int i = 0; i <= 2400; i++) {
			boolean answer = leap.contains(i);
			boolean result = isLeapYear(i);
			if (result != answer) {
				System.out.println("Error:" + i);
			}
		}
		System.out.println("Test finished");
	}

	public static boolean isLeapYear(int year) {
		boolean n4 = year % 4 == 0;
		boolean n100 = year % 100 == 0;
		boolean n400 = year % 400 == 0;

		if (n400) {
			return true;
		} else if (n100) {
			return false;
		} else if (n4) {
			return true;
		}

		return false;
	}

	private static void initLeap(Set<Integer> leap) {
		leap.add(1804);
		leap.add(1808);
		leap.add(1812);
		leap.add(1816);
		leap.add(1820);
		leap.add(1824);
		leap.add(1828);
		leap.add(1832);
		leap.add(1836);
		leap.add(1840);
		leap.add(1844);
		leap.add(1848);
		leap.add(1852);
		leap.add(1856);
		leap.add(1860);
		leap.add(1864);
		leap.add(1868);
		leap.add(1872);
		leap.add(1876);
		leap.add(1880);
		leap.add(1884);
		leap.add(1888);
		leap.add(1892);
		leap.add(1896);
		leap.add(1904);
		leap.add(1908);
		leap.add(1912);
		leap.add(1916);
		leap.add(1920);
		leap.add(1924);
		leap.add(1928);
		leap.add(1932);
		leap.add(1936);
		leap.add(1940);
		leap.add(1944);
		leap.add(1948);
		leap.add(1952);
		leap.add(1956);
		leap.add(1960);
		leap.add(1964);
		leap.add(1968);
		leap.add(1972);
		leap.add(1976);
		leap.add(1980);
		leap.add(1984);
		leap.add(1988);
		leap.add(1992);
		leap.add(1996);
		leap.add(2000);
		leap.add(2004);
		leap.add(2008);
		leap.add(2012);
		leap.add(2016);
		leap.add(2020);
		leap.add(2024);
		leap.add(2028);
		leap.add(2032);
		leap.add(2036);
		leap.add(2040);
		leap.add(2044);
		leap.add(2048);
		leap.add(2052);
		leap.add(2056);
		leap.add(2060);
		leap.add(2064);
		leap.add(2068);
		leap.add(2072);
		leap.add(2076);
		leap.add(2080);
		leap.add(2084);
		leap.add(2088);
		leap.add(2092);
		leap.add(2096);
		leap.add(2104);
		leap.add(2108);
		leap.add(2112);
		leap.add(2116);
		leap.add(2120);
		leap.add(2124);
		leap.add(2128);
		leap.add(2132);
		leap.add(2136);
		leap.add(2140);
		leap.add(2144);
		leap.add(2148);
		leap.add(2152);
		leap.add(2156);
		leap.add(2160);
		leap.add(2164);
		leap.add(2168);
		leap.add(2172);
		leap.add(2176);
		leap.add(2180);
		leap.add(2184);
		leap.add(2188);
		leap.add(2192);
		leap.add(2196);
		leap.add(2204);
		leap.add(2208);
		leap.add(2212);
		leap.add(2216);
		leap.add(2220);
		leap.add(2224);
		leap.add(2228);
		leap.add(2232);
		leap.add(2236);
		leap.add(2240);
		leap.add(2244);
		leap.add(2248);
		leap.add(2252);
		leap.add(2256);
		leap.add(2260);
		leap.add(2264);
		leap.add(2268);
		leap.add(2272);
		leap.add(2276);
		leap.add(2280);
		leap.add(2284);
		leap.add(2288);
		leap.add(2292);
		leap.add(2296);
		leap.add(2304);
		leap.add(2308);
		leap.add(2312);
		leap.add(2316);
		leap.add(2320);
		leap.add(2324);
		leap.add(2328);
		leap.add(2332);
		leap.add(2336);
		leap.add(2340);
		leap.add(2344);
		leap.add(2348);
		leap.add(2352);
		leap.add(2356);
		leap.add(2360);
		leap.add(2364);
		leap.add(2368);
		leap.add(2372);
		leap.add(2376);
		leap.add(2380);
		leap.add(2384);
		leap.add(2388);
		leap.add(2392);
		leap.add(2396);
		leap.add(2400);
	}
}
