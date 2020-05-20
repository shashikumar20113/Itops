/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lti.itops.ipac.custcatmgmt.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.impl.TowerCustomerMapImpl;
import com.lti.itops.ipac.custcatmgmt.model.impl.TowerCustomerMapModelImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TowerCustomerMapPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the tower customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TowerCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.TowerCustomerMapUtil
 * @generated
 */
@ProviderType
public class TowerCustomerMapPersistenceImpl extends BasePersistenceImpl<TowerCustomerMap>
	implements TowerCustomerMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TowerCustomerMapUtil} to access the tower customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TowerCustomerMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TowerCustomerMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TowerCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATION =
		new FinderPath(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TowerCustomerMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByorganization",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION =
		new FinderPath(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TowerCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByorganization",
			new String[] { Long.class.getName() },
			TowerCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATION = new FinderPath(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByorganization",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tower customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching tower customer maps
	 */
	@Override
	public List<TowerCustomerMap> findByorganization(long organizationId) {
		return findByorganization(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tower customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of tower customer maps
	 * @param end the upper bound of the range of tower customer maps (not inclusive)
	 * @return the range of matching tower customer maps
	 */
	@Override
	public List<TowerCustomerMap> findByorganization(long organizationId,
		int start, int end) {
		return findByorganization(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tower customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of tower customer maps
	 * @param end the upper bound of the range of tower customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tower customer maps
	 */
	@Override
	public List<TowerCustomerMap> findByorganization(long organizationId,
		int start, int end,
		OrderByComparator<TowerCustomerMap> orderByComparator) {
		return findByorganization(organizationId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tower customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of tower customer maps
	 * @param end the upper bound of the range of tower customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tower customer maps
	 */
	@Override
	public List<TowerCustomerMap> findByorganization(long organizationId,
		int start, int end,
		OrderByComparator<TowerCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATION;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<TowerCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TowerCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TowerCustomerMap towerCustomerMap : list) {
					if ((organizationId != towerCustomerMap.getOrganizationId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TOWERCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TowerCustomerMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<TowerCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TowerCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tower customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tower customer map
	 * @throws NoSuchTowerCustomerMapException if a matching tower customer map could not be found
	 */
	@Override
	public TowerCustomerMap findByorganization_First(long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator)
		throws NoSuchTowerCustomerMapException {
		TowerCustomerMap towerCustomerMap = fetchByorganization_First(organizationId,
				orderByComparator);

		if (towerCustomerMap != null) {
			return towerCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTowerCustomerMapException(msg.toString());
	}

	/**
	 * Returns the first tower customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	 */
	@Override
	public TowerCustomerMap fetchByorganization_First(long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator) {
		List<TowerCustomerMap> list = findByorganization(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tower customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tower customer map
	 * @throws NoSuchTowerCustomerMapException if a matching tower customer map could not be found
	 */
	@Override
	public TowerCustomerMap findByorganization_Last(long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator)
		throws NoSuchTowerCustomerMapException {
		TowerCustomerMap towerCustomerMap = fetchByorganization_Last(organizationId,
				orderByComparator);

		if (towerCustomerMap != null) {
			return towerCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTowerCustomerMapException(msg.toString());
	}

	/**
	 * Returns the last tower customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	 */
	@Override
	public TowerCustomerMap fetchByorganization_Last(long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator) {
		int count = countByorganization(organizationId);

		if (count == 0) {
			return null;
		}

		List<TowerCustomerMap> list = findByorganization(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tower customer maps before and after the current tower customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param towerCustomerId the primary key of the current tower customer map
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tower customer map
	 * @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	 */
	@Override
	public TowerCustomerMap[] findByorganization_PrevAndNext(
		long towerCustomerId, long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator)
		throws NoSuchTowerCustomerMapException {
		TowerCustomerMap towerCustomerMap = findByPrimaryKey(towerCustomerId);

		Session session = null;

		try {
			session = openSession();

			TowerCustomerMap[] array = new TowerCustomerMapImpl[3];

			array[0] = getByorganization_PrevAndNext(session, towerCustomerMap,
					organizationId, orderByComparator, true);

			array[1] = towerCustomerMap;

			array[2] = getByorganization_PrevAndNext(session, towerCustomerMap,
					organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TowerCustomerMap getByorganization_PrevAndNext(Session session,
		TowerCustomerMap towerCustomerMap, long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOWERCUSTOMERMAP_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TowerCustomerMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(towerCustomerMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TowerCustomerMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tower customer maps where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByorganization(long organizationId) {
		for (TowerCustomerMap towerCustomerMap : findByorganization(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(towerCustomerMap);
		}
	}

	/**
	 * Returns the number of tower customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching tower customer maps
	 */
	@Override
	public int countByorganization(long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATION;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOWERCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2 = "towerCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_T_O = new FinderPath(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TowerCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByT_O",
			new String[] { Long.class.getName(), Long.class.getName() },
			TowerCustomerMapModelImpl.TOWERID_COLUMN_BITMASK |
			TowerCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_O = new FinderPath(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_O",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the tower customer map where towerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTowerCustomerMapException} if it could not be found.
	 *
	 * @param towerId the tower ID
	 * @param organizationId the organization ID
	 * @return the matching tower customer map
	 * @throws NoSuchTowerCustomerMapException if a matching tower customer map could not be found
	 */
	@Override
	public TowerCustomerMap findByT_O(long towerId, long organizationId)
		throws NoSuchTowerCustomerMapException {
		TowerCustomerMap towerCustomerMap = fetchByT_O(towerId, organizationId);

		if (towerCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("towerId=");
			msg.append(towerId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTowerCustomerMapException(msg.toString());
		}

		return towerCustomerMap;
	}

	/**
	 * Returns the tower customer map where towerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param towerId the tower ID
	 * @param organizationId the organization ID
	 * @return the matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	 */
	@Override
	public TowerCustomerMap fetchByT_O(long towerId, long organizationId) {
		return fetchByT_O(towerId, organizationId, true);
	}

	/**
	 * Returns the tower customer map where towerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param towerId the tower ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	 */
	@Override
	public TowerCustomerMap fetchByT_O(long towerId, long organizationId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { towerId, organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_T_O,
					finderArgs, this);
		}

		if (result instanceof TowerCustomerMap) {
			TowerCustomerMap towerCustomerMap = (TowerCustomerMap)result;

			if ((towerId != towerCustomerMap.getTowerId()) ||
					(organizationId != towerCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TOWERCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_T_O_TOWERID_2);

			query.append(_FINDER_COLUMN_T_O_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(towerId);

				qPos.add(organizationId);

				List<TowerCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_T_O, finderArgs,
						list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TowerCustomerMapPersistenceImpl.fetchByT_O(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TowerCustomerMap towerCustomerMap = list.get(0);

					result = towerCustomerMap;

					cacheResult(towerCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_T_O, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TowerCustomerMap)result;
		}
	}

	/**
	 * Removes the tower customer map where towerId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param towerId the tower ID
	 * @param organizationId the organization ID
	 * @return the tower customer map that was removed
	 */
	@Override
	public TowerCustomerMap removeByT_O(long towerId, long organizationId)
		throws NoSuchTowerCustomerMapException {
		TowerCustomerMap towerCustomerMap = findByT_O(towerId, organizationId);

		return remove(towerCustomerMap);
	}

	/**
	 * Returns the number of tower customer maps where towerId = &#63; and organizationId = &#63;.
	 *
	 * @param towerId the tower ID
	 * @param organizationId the organization ID
	 * @return the number of matching tower customer maps
	 */
	@Override
	public int countByT_O(long towerId, long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_O;

		Object[] finderArgs = new Object[] { towerId, organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TOWERCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_T_O_TOWERID_2);

			query.append(_FINDER_COLUMN_T_O_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(towerId);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_T_O_TOWERID_2 = "towerCustomerMap.towerId = ? AND ";
	private static final String _FINDER_COLUMN_T_O_ORGANIZATIONID_2 = "towerCustomerMap.organizationId = ?";

	public TowerCustomerMapPersistenceImpl() {
		setModelClass(TowerCustomerMap.class);
	}

	/**
	 * Caches the tower customer map in the entity cache if it is enabled.
	 *
	 * @param towerCustomerMap the tower customer map
	 */
	@Override
	public void cacheResult(TowerCustomerMap towerCustomerMap) {
		entityCache.putResult(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapImpl.class, towerCustomerMap.getPrimaryKey(),
			towerCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_T_O,
			new Object[] {
				towerCustomerMap.getTowerId(),
				towerCustomerMap.getOrganizationId()
			}, towerCustomerMap);

		towerCustomerMap.resetOriginalValues();
	}

	/**
	 * Caches the tower customer maps in the entity cache if it is enabled.
	 *
	 * @param towerCustomerMaps the tower customer maps
	 */
	@Override
	public void cacheResult(List<TowerCustomerMap> towerCustomerMaps) {
		for (TowerCustomerMap towerCustomerMap : towerCustomerMaps) {
			if (entityCache.getResult(
						TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TowerCustomerMapImpl.class,
						towerCustomerMap.getPrimaryKey()) == null) {
				cacheResult(towerCustomerMap);
			}
			else {
				towerCustomerMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tower customer maps.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TowerCustomerMapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tower customer map.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TowerCustomerMap towerCustomerMap) {
		entityCache.removeResult(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapImpl.class, towerCustomerMap.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TowerCustomerMapModelImpl)towerCustomerMap,
			true);
	}

	@Override
	public void clearCache(List<TowerCustomerMap> towerCustomerMaps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TowerCustomerMap towerCustomerMap : towerCustomerMaps) {
			entityCache.removeResult(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TowerCustomerMapImpl.class, towerCustomerMap.getPrimaryKey());

			clearUniqueFindersCache((TowerCustomerMapModelImpl)towerCustomerMap,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		TowerCustomerMapModelImpl towerCustomerMapModelImpl) {
		Object[] args = new Object[] {
				towerCustomerMapModelImpl.getTowerId(),
				towerCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_T_O, args, Long.valueOf(1),
			false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_T_O, args,
			towerCustomerMapModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TowerCustomerMapModelImpl towerCustomerMapModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					towerCustomerMapModelImpl.getTowerId(),
					towerCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_T_O, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_T_O, args);
		}

		if ((towerCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_T_O.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					towerCustomerMapModelImpl.getOriginalTowerId(),
					towerCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_T_O, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_T_O, args);
		}
	}

	/**
	 * Creates a new tower customer map with the primary key. Does not add the tower customer map to the database.
	 *
	 * @param towerCustomerId the primary key for the new tower customer map
	 * @return the new tower customer map
	 */
	@Override
	public TowerCustomerMap create(long towerCustomerId) {
		TowerCustomerMap towerCustomerMap = new TowerCustomerMapImpl();

		towerCustomerMap.setNew(true);
		towerCustomerMap.setPrimaryKey(towerCustomerId);

		towerCustomerMap.setCompanyId(companyProvider.getCompanyId());

		return towerCustomerMap;
	}

	/**
	 * Removes the tower customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param towerCustomerId the primary key of the tower customer map
	 * @return the tower customer map that was removed
	 * @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	 */
	@Override
	public TowerCustomerMap remove(long towerCustomerId)
		throws NoSuchTowerCustomerMapException {
		return remove((Serializable)towerCustomerId);
	}

	/**
	 * Removes the tower customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tower customer map
	 * @return the tower customer map that was removed
	 * @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	 */
	@Override
	public TowerCustomerMap remove(Serializable primaryKey)
		throws NoSuchTowerCustomerMapException {
		Session session = null;

		try {
			session = openSession();

			TowerCustomerMap towerCustomerMap = (TowerCustomerMap)session.get(TowerCustomerMapImpl.class,
					primaryKey);

			if (towerCustomerMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTowerCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(towerCustomerMap);
		}
		catch (NoSuchTowerCustomerMapException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TowerCustomerMap removeImpl(TowerCustomerMap towerCustomerMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(towerCustomerMap)) {
				towerCustomerMap = (TowerCustomerMap)session.get(TowerCustomerMapImpl.class,
						towerCustomerMap.getPrimaryKeyObj());
			}

			if (towerCustomerMap != null) {
				session.delete(towerCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (towerCustomerMap != null) {
			clearCache(towerCustomerMap);
		}

		return towerCustomerMap;
	}

	@Override
	public TowerCustomerMap updateImpl(TowerCustomerMap towerCustomerMap) {
		boolean isNew = towerCustomerMap.isNew();

		if (!(towerCustomerMap instanceof TowerCustomerMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(towerCustomerMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(towerCustomerMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in towerCustomerMap proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TowerCustomerMap implementation " +
				towerCustomerMap.getClass());
		}

		TowerCustomerMapModelImpl towerCustomerMapModelImpl = (TowerCustomerMapModelImpl)towerCustomerMap;

		Session session = null;

		try {
			session = openSession();

			if (towerCustomerMap.isNew()) {
				session.save(towerCustomerMap);

				towerCustomerMap.setNew(false);
			}
			else {
				towerCustomerMap = (TowerCustomerMap)session.merge(towerCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TowerCustomerMapModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					towerCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((towerCustomerMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						towerCustomerMapModelImpl.getOriginalOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION,
					args);

				args = new Object[] {
						towerCustomerMapModelImpl.getOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATION,
					args);
			}
		}

		entityCache.putResult(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TowerCustomerMapImpl.class, towerCustomerMap.getPrimaryKey(),
			towerCustomerMap, false);

		clearUniqueFindersCache(towerCustomerMapModelImpl, false);
		cacheUniqueFindersCache(towerCustomerMapModelImpl);

		towerCustomerMap.resetOriginalValues();

		return towerCustomerMap;
	}

	/**
	 * Returns the tower customer map with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tower customer map
	 * @return the tower customer map
	 * @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	 */
	@Override
	public TowerCustomerMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTowerCustomerMapException {
		TowerCustomerMap towerCustomerMap = fetchByPrimaryKey(primaryKey);

		if (towerCustomerMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTowerCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return towerCustomerMap;
	}

	/**
	 * Returns the tower customer map with the primary key or throws a {@link NoSuchTowerCustomerMapException} if it could not be found.
	 *
	 * @param towerCustomerId the primary key of the tower customer map
	 * @return the tower customer map
	 * @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	 */
	@Override
	public TowerCustomerMap findByPrimaryKey(long towerCustomerId)
		throws NoSuchTowerCustomerMapException {
		return findByPrimaryKey((Serializable)towerCustomerId);
	}

	/**
	 * Returns the tower customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tower customer map
	 * @return the tower customer map, or <code>null</code> if a tower customer map with the primary key could not be found
	 */
	@Override
	public TowerCustomerMap fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TowerCustomerMapImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TowerCustomerMap towerCustomerMap = (TowerCustomerMap)serializable;

		if (towerCustomerMap == null) {
			Session session = null;

			try {
				session = openSession();

				towerCustomerMap = (TowerCustomerMap)session.get(TowerCustomerMapImpl.class,
						primaryKey);

				if (towerCustomerMap != null) {
					cacheResult(towerCustomerMap);
				}
				else {
					entityCache.putResult(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TowerCustomerMapImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TowerCustomerMapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return towerCustomerMap;
	}

	/**
	 * Returns the tower customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param towerCustomerId the primary key of the tower customer map
	 * @return the tower customer map, or <code>null</code> if a tower customer map with the primary key could not be found
	 */
	@Override
	public TowerCustomerMap fetchByPrimaryKey(long towerCustomerId) {
		return fetchByPrimaryKey((Serializable)towerCustomerId);
	}

	@Override
	public Map<Serializable, TowerCustomerMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TowerCustomerMap> map = new HashMap<Serializable, TowerCustomerMap>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TowerCustomerMap towerCustomerMap = fetchByPrimaryKey(primaryKey);

			if (towerCustomerMap != null) {
				map.put(primaryKey, towerCustomerMap);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TowerCustomerMapImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TowerCustomerMap)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TOWERCUSTOMERMAP_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TowerCustomerMap towerCustomerMap : (List<TowerCustomerMap>)q.list()) {
				map.put(towerCustomerMap.getPrimaryKeyObj(), towerCustomerMap);

				cacheResult(towerCustomerMap);

				uncachedPrimaryKeys.remove(towerCustomerMap.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TowerCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TowerCustomerMapImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the tower customer maps.
	 *
	 * @return the tower customer maps
	 */
	@Override
	public List<TowerCustomerMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tower customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tower customer maps
	 * @param end the upper bound of the range of tower customer maps (not inclusive)
	 * @return the range of tower customer maps
	 */
	@Override
	public List<TowerCustomerMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tower customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tower customer maps
	 * @param end the upper bound of the range of tower customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tower customer maps
	 */
	@Override
	public List<TowerCustomerMap> findAll(int start, int end,
		OrderByComparator<TowerCustomerMap> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tower customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tower customer maps
	 * @param end the upper bound of the range of tower customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tower customer maps
	 */
	@Override
	public List<TowerCustomerMap> findAll(int start, int end,
		OrderByComparator<TowerCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TowerCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TowerCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TOWERCUSTOMERMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOWERCUSTOMERMAP;

				if (pagination) {
					sql = sql.concat(TowerCustomerMapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TowerCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TowerCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tower customer maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TowerCustomerMap towerCustomerMap : findAll()) {
			remove(towerCustomerMap);
		}
	}

	/**
	 * Returns the number of tower customer maps.
	 *
	 * @return the number of tower customer maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOWERCUSTOMERMAP);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TowerCustomerMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tower customer map persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TowerCustomerMapImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TOWERCUSTOMERMAP = "SELECT towerCustomerMap FROM TowerCustomerMap towerCustomerMap";
	private static final String _SQL_SELECT_TOWERCUSTOMERMAP_WHERE_PKS_IN = "SELECT towerCustomerMap FROM TowerCustomerMap towerCustomerMap WHERE towerCustomerId IN (";
	private static final String _SQL_SELECT_TOWERCUSTOMERMAP_WHERE = "SELECT towerCustomerMap FROM TowerCustomerMap towerCustomerMap WHERE ";
	private static final String _SQL_COUNT_TOWERCUSTOMERMAP = "SELECT COUNT(towerCustomerMap) FROM TowerCustomerMap towerCustomerMap";
	private static final String _SQL_COUNT_TOWERCUSTOMERMAP_WHERE = "SELECT COUNT(towerCustomerMap) FROM TowerCustomerMap towerCustomerMap WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "towerCustomerMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TowerCustomerMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TowerCustomerMap exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TowerCustomerMapPersistenceImpl.class);
}