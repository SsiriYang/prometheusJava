package com.bdwise.prometheus.client.builder;

/**
 * @Description 通过枚举创建查询的构造器
 * @Date 2020/9/28 11:04
 * @author YS
 */
@SuppressWarnings("unchecked")
public enum QueryBuilderType {
	RangeQuery{


		@Override
		public RangeQueryBuilder newInstance(String prometheusUrl) {
			return new RangeQueryBuilder(prometheusUrl);
		}
		
	},
	InstantQuery{

		@Override
		public InstantQueryBuilder newInstance(String prometheusUrl) {
			return new InstantQueryBuilder(prometheusUrl);
		}
		
	},
	SeriesMetadaQuery{


		@Override
		public QueryBuilder newInstance(String prometheusUrl) {
			return new SeriesMetaQueryBuilder(prometheusUrl);
		}
		
	},
	LabelMetadaQuery{


		@Override
		public QueryBuilder newInstance(String prometheusUrl) {
			return new LabelMetaQueryBuilder(prometheusUrl);
		}
		
	},

	TargetMetadaQuery{


		@Override
		public QueryBuilder newInstance(String prometheusUrl) {
			return new TargetMetaQueryBuilder(prometheusUrl);
		}
		
	},

	AlertManagerMetadaQuery{


		@Override
		public QueryBuilder newInstance(String prometheusUrl) {
			return new AlertManagerMetaQueryBuilder(prometheusUrl);
		}
		
	},
	
	StatusMetadaQuery{


		@Override
		public QueryBuilder newInstance(String prometheusUrl) {
			return new StatusMetaQueryBuilder(prometheusUrl);
		}
		
	};

	
	public abstract <T extends QueryBuilder> T newInstance(String prometheusUrl);
}
